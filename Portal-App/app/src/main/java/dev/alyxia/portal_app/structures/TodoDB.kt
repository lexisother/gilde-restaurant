package dev.alyxia.portal_app.structures

typealias TodoDB = Map<String, TodoDBItem>

data class TodoDBItem(
    val name: String,
    val content: String,
    val priority: Int? = null
)