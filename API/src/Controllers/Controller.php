<?php

namespace App\Controllers;

use ReflectionClass;

abstract class Controller
{
    private function __name()
    {
        return (new ReflectionClass($this))->getShortName();
    }
}
