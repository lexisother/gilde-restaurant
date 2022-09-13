<?php

namespace App\Controllers;

class HealthController {
    public function getHealth() {
        echo '{"ok": true}';
    }
}