<?php

namespace App\Controllers;

use App\Models\Product;

class ProductsController
{
    public function fetchProduct()
    {
        $data = json_decode(file_get_contents("php://input"));
        if (empty((array)$data)) {
            echo json_encode(Product::all());
        }
    }
}