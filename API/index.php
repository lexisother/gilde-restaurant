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

$router->mount("/api", function () use ($router) {
    $router->all("/health", function () {
        echo '{"ok": true}';
    });
});

$router->run();
