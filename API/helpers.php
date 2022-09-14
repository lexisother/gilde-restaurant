<?php

use App\Lib\stdObject;
use Illuminate\Container\Container;

function app($abstract = null, array $parameters = [])
{
    if (is_null($abstract)) {
        return Container::getInstance();
    }

    return Container::getInstance()->make($abstract, $parameters);
}

function jsonError(string $message) {
    echo json_encode(new stdObject(["error" => $message]));
}
