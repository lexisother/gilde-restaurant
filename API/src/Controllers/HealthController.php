<?php

namespace App\Controllers;

use App\Models\Product;

class HealthController
{
    public function getHealth()
    {
        $prod = new Product;
        $prod->name = 'test';
        $prod->description = 'test test test';
        $prod->price = 20;
        $prod->save();
        echo '{"ok": true}';
    }
}

