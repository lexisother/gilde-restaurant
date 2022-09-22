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
            $this->id = $id;
        } else {
            throw new InvalidArgumentException('$id must be an integer');
        }

        if (is_string($name)) {
            $this->name = $name;
        } else {
            throw new InvalidArgumentException('$name must be a string');
        }

        if (is_string($email)) {
            $this->email = $email;
        } else {
            throw new InvalidArgumentException('$email must be a string');
        }

        if (is_string($password)) {
            $this->password = $password;
        } else {
            throw new InvalidArgumentException('$password must be a string');
        }
    }
}
