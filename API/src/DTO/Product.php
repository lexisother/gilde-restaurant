<?php

namespace App\DTO;

use InvalidArgumentException;

class Product
{
    public int $id;
    public string $name;
    public string $description;
    public float $price;
    public bool $spanish;
    public bool $warm;
    public bool $cold;
    public bool $vega;

    public function __construct($id, $name, $description, $price, $spanish, $warm, $cold, $vega)
    {
        if (is_int($id)) {
            $this->id = $id;
        } else {
            throw new InvalidArgumentException('id must be an integer');
        }

        if (is_string($name)) {
            $this->name = $name;
        } else {
            throw new InvalidArgumentException('$name must be a string');
        }

        if (is_string($description)) {
            $this->description = $description;
        } else {
            throw new InvalidArgumentException('$description must be a string');
        }

        if (is_float($price)) {
            $this->price = $price;
        } else {
            throw new InvalidArgumentException('$price must be a float');
        }

        if (is_bool($spanish)) {
            $this->spanish = $spanish;
        } else {
            throw new InvalidArgumentException('$spanish must be a boolean');
        }

        if (is_bool($warm)) {
            $this->warm = $warm;
        } else {
            throw new InvalidArgumentException('$warm must be a boolean');
        }

        if (is_bool($cold)) {
            $this->cold = $cold;
        } else {
            throw new InvalidArgumentException('$cold must be a boolean');
        }

        if (is_bool($vega)) {
            $this->vega = $vega;
        } else {
            throw new InvalidArgumentException('$vega must be a boolean');
        }
    }
}
