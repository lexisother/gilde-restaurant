<?php
require __DIR__ . "/vendor/autoload.php";

use Bramus\Router\Router;
use Illuminate\Container\Container;
use Illuminate\Database\Capsule\Manager as Capsule;
use Illuminate\Events\Dispatcher;
use Whoops\Handler\JsonResponseHandler;
use Whoops\Run;

// Make sure all data is sent as JSON.
header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST, DELETE, OPTIONS");
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
    'driver' => 'pgsql',
    'host' => getenv('GITHUB_API_URL') ? 'mariadb' : 'localhost',
    'database' => 'GDOS_Restaurant',
    'username' => 'root',
    'password' => 'root',
    'charset' => 'utf8',
    'collation' => 'utf8_unicode_ci',
]);
$capsule->setEventDispatcher(new Dispatcher(new Container()));
$capsule->setAsGlobal();
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
