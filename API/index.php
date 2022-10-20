<?php
require __DIR__ . "/vendor/autoload.php";

use Bramus\Router\Router;
use Illuminate\Container\Container;
use Illuminate\Database\Capsule\Manager as Capsule;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Seeder;
use Illuminate\Events\Dispatcher;
use Whoops\Handler\JsonResponseHandler;
use Whoops\Run;

// Make sure all data is sent as JSON.
header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: *");
header("Access-Control-Allow-Headers: *");
if ($_SERVER["REQUEST_METHOD"] === "OPTIONS") {
    return 0;
}

// Set up the error handler
$whoops = new Run();
$whoops->pushHandler(new JsonResponseHandler());
$whoops->register();

#region Illuminate setup {{{
$capsule = new Capsule();
$capsule->addConnection([
    'driver'    => 'pgsql',
    // 'host'      => getenv('CI') ? 'postgres' : 'localhost',
    'host'      => 'localhost',
    'database'  => getenv('CI') ? 'postgres' : 'GDOS_Restaurant',
    'username'  => getenv('CI') ? 'postgres' : 'root',
    'password'  => getenv('CI') ? ''         : 'root',
    'charset'   => 'utf8',
    'collation' => 'utf8_unicode_ci',
]);
$capsule->setEventDispatcher(new Dispatcher(new Container()));
$capsule->setAsGlobal();
$Schema = $capsule->schema();

// Table creations {{{
if (!$Schema->hasTable('producten')) {
    $Schema->create('producten', function (Blueprint $table) {
        $table->id();
        $table->string('name', 50)->unique();
        $table->text('description');
        $table->float('price');
        $table->boolean('spanish')->nullable();
        $table->boolean('warm')->nullable();
        $table->boolean('cold')->nullable();
        $table->boolean('vega')->nullable();
        $table->timestamps();
    });
}
if (!$Schema->hasTable('gebruikers')) {
    $Schema->create('gebruikers', function (Blueprint $table) {
        $table->id();
        $table->string('name', 50);
        $table->text('email')->unique();
        $table->text('password');
        $table->boolean('clocked')->default('FALSE');
    });
}
// }}}

$capsule->bootEloquent();
#endregion }}}

$container = app();

$router = new Router();
$router->setNamespace("\App\Controllers");

$router->all("/health", 'HealthController@getHealth');

$router->get("/products", 'ProductsController@fetchProduct');
$router->post("/products", 'ProductsController@createProduct');
$router->patch("/products/(\d+)", 'ProductsController@editProduct');
$router->delete("/products/(\d+)", 'ProductsController@deleteProduct');

$router->post("/auth/register", "UserController@registerUser");
$router->post("/auth/login", "UserController@loginUser");
$router->post("/user/clock", "UserController@clockUser");

$router->run();
