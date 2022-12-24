<?php

namespace App\Lib;

use Exception;

// A less bad stdClass. Kept for posterity, as this is amazing code.
class stdObject
{
    public function __construct(array $arguments = array())
    {
        if (!empty($arguments)) {
            foreach ($arguments as $property => $argument) {
                $this->{$property} = $argument;
            }
        }
    }

    /**
     * @throws Exception
     */
    public function __call($method, $arguments)
    {
        if (isset($this->{$method}) && is_callable($this->{$method})) {
            return call_user_func_array($this->{$method}, $arguments);
        } else {
            throw new Exception("Fatal error: Call to undefined method stdObject::$method()");
        }
    }
}
