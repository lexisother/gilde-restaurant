<?php

namespace App\Controllers;

use App\Models\Product;

class ProductsController
{
    public function fetchProduct()
    {
        // Get JSON body (regardless of GET or POST)
        $data = json_decode(file_get_contents("php://input"));

        // No body? Fetch all products.
        if (empty((array)$data)) {
            echo json_encode(Product::all());
        } else {
            // Name provided?
            if (isset($data->name)) {
                // Find product with provided name.
                $product = Product::where('name', $data->name)->get();
                // Found? Send it back.
                if (!$product->isEmpty()) {
                    echo json_encode($product);
                } else {
                    jsonError("Not found!");
                }
            } else {
                jsonError("Please provide a name!");
            }
        }
    }
}
