<?php

namespace App\DTO;

use InvalidArgumentException;

class User
{
    public int $id;
    public string $name;
    public string $email;
    public string $password;

    public function __construct($id, $name, $email, $password)
    {
        if (is_int($id)) {
            throw new InvalidArgumentException('$id must be an integer');
        }

        if (is_string($name)) {
            throw new InvalidArgumentException('$name must be a string');
        }

        if (is_string($email)) {
            throw new InvalidArgumentException('$email must be a string');
        }

        if (is_string($password)) {
            throw new InvalidArgumentException('$password must be a string');
        }
    }
}
