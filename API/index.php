<?php
require __DIR__ . "/vendor/autoload.php";

use Bramus\Router\Router;
use Whoops\Handler\PrettyPageHandler;
use Whoops\Run;

$whoops = new Run();
$whoops->pushHandler(new PrettyPageHandler());
$whoops->register();

header("Content-Type: application/json");
$router = new Router();
$router->setNamespace("\App\Controllers");

$router->all("/health", 'HealthController@getHealth');

$router->run();
