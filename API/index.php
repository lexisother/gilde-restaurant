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

// Set up the error handler
$whoops = new Run();
$whoops->pushHandler(new JsonResponseHandler());
$whoops->register();

#region Illuminate setup {{{
$capsule = new Capsule();
$capsule->addConnection([
    'driver' => 'mysql',
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
// $router->post("/products", 'ProductsController@fetchProduct');

$router->run();
