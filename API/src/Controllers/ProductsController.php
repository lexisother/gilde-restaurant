<?php

namespace App\Controllers;

use App\DTO\Product as DTOProduct;
use App\Models\Product;
use Exception;

class ProductsController
{
    /**
     * @throws Exception
     */
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
                // Find product(s) with provided name.
                $products = Product::where('name', $data->name);

                // Fail if there are no elements.
                $products->firstOrFail();

                // Send the list back to the client.
                echo json_encode($products->get());
            } else {
                throw new Exception("Please provide a name!");
            }
        }
    }

    /**
     * @throws Exception
     */
    public function createProduct()
    {
        $data = json_decode(file_get_contents("php://input"));

        if (!empty((array)$data)) {
            $prod = new DTOProduct(0, $data->name, $data->description, $data->price);
            $res = new Product([
                'name' => $prod->name,
                'description' => $prod->description,
                'price' => $prod->price,
            ]);
            $res->save();
            echo json_encode($res);
        } else {
            throw new Exception("No data provided!");
        }
    }

    public function deleteProduct($id)
    {
        $item = Product::findOrFail($id);
        $item->delete();
    }
}
