<?php
require __DIR__ . "/vendor/autoload.php";

use Bramus\Router\Router;
use Whoops\Handler\JsonResponseHandler;
use Whoops\Run;

// Make sure all data is sent as JSON.
header("Content-Type: application/json");

// Set up the error handler
$whoops = new Run();
$whoops->pushHandler(new JsonResponseHandler());
$whoops->register();

header("Content-Type: application/json");
$router = new Router();
$router->setNamespace("\App\Controllers");

$router->all("/health", 'HealthController@getHealth');

$router->run();
