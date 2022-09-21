<?php

namespace App\Controllers;

use App\Models\User;
use Exception;

class UserController extends Controller
{
    /**
     * @throws Exception
     */
    public function registerUser()
    {
        // Check if this is a form request or a POST request:
        // TODO: Test if this actually works.
        if (isset($_POST['email'])) {
            $data = $_POST;
        } else {
            $data = json_decode(file_get_contents("php://input"));
        }

        if (!empty((array)$data)) {
            if (!User::where('email', $data->email)->exists()) {
                // TODO: Create a user here.
            } else {
                throw new Exception("User with this email already exists!");
            }
        } else {
            throw new Exception("No request body was provided.");
        }
    }

    public function loginUser()
    {
        TODO();
    }
}
