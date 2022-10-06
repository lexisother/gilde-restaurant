<?php

use Illuminate\Container\Container;

/**
 * @param $abstract
 * @param array $parameters
 * @return Closure|Container|mixed|object|null
 * @throws BindingResolutionException
 */
function app($abstract = null, array $parameters = [])
{
    if (is_null($abstract)) {
        return Container::getInstance();
    }

    return Container::getInstance()->make($abstract, $parameters);
}

class NotImplementedException extends BadMethodCallException
{
}

/**
 * @param string $reason
 * @throws NotImplementedException
 */
function TODO(string $reason = "")
{
    if (empty($reason)) {
        $caller = debug_backtrace()[1]['function'];
        throw new NotImplementedException("Method '$caller' is not implemented.");
    } else {
        throw new NotImplementedException($reason);
    }
}
