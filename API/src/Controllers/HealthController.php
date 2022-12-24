<?php

namespace App\Controllers;

class HealthController extends Controller
{
    public function getHealth()
    {
//        $prod = new Product;
//        $prod->name = 'test 1';
//        $prod->description = 'test test test';
//        $prod->price = 15;
//        $prod->save();
        echo '{"ok": true}';
    }
}
