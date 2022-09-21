<?php

namespace App\Controllers;

abstract class Controller
{
    private function __name()
    {
        return (new ReflectionClass($this))->getShortName();
    }
}
