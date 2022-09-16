<?php

namespace App\DTO;

use InvalidArgumentException;

class Product
{
    public int $id;
    public string $name;
    public string $description;
    public float $price;

    public function __construct($id, $name, $description, $price)
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
    }
}
