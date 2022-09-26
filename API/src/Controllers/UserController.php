<?php

namespace App\Controllers;

use App\DTO\User as DTOUser;
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
            $data = (object)$_POST;
        } else {
            $data = json_decode(file_get_contents("php://input"));
        }

        // Check if the data is correct.
        $this->checkRegData($data);

        if (!empty((array)$data)) {
            if (!User::where('email', $data->email)->exists()) {
                $pass = md5($data->password);
                $dtoUser = new DTOUser(0, $data->name, $data->email, $pass);
                $user = new User([
                    'name' => $dtoUser->name,
                    'email' => $dtoUser->email,
                    'password' => $dtoUser->password
                ]);
                $user->save();
            } else {
                throw new Exception("User with this email already exists!");
            }
        } else {
            throw new Exception("No request body was provided.");
        }
    }

    private function checkRegData($data)
    {
        if (empty($data->email)) {
            throw new Exception("Email is required.");
        }

        if (empty($data->password)) {
            throw new Exception("Password is required.");
        }
    }

    public function loginUser()
    {
        $data = json_decode(file_get_contents("php://input"));
        $user = User::where('email', $data->email)->first();
        if (!empty($user)) {
            if (md5($data->password) == $user->password) {
                echo json_encode($user->first());
            } else {
                throw new Exception("Password doesn't match!");
            }
        } else {
            throw new Exception("User not found!");
        }
    }
}
