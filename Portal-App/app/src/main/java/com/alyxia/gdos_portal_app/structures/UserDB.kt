package com.alyxia.gdos_portal_app.structures

typealias UserDB = List<User>

data class User(
    val username: String,
    val password: String
)
