<?php

namespace App\Controllers;

use App\Models\Reservation;
use Exception;

class ReservationController extends Controller
{
    /**
     * @return void
     * @throws Exception
     */
    public function createReservation()
    {
        $data = json_decode(file_get_contents("php://input"));

        if (!empty((array)$data)) {
            if (isset($data->table)) {
                $res = new Reservation([
                    'table' => $data->table,
                    'items' => $data->items
                ]);
                $res->save();
                echo json_encode($res);
            } else {
                throw new Exception("Please provide the table number! (1-10)");
            }
        } else {
            throw new Exception("No data provided!");
        }
    }
}
