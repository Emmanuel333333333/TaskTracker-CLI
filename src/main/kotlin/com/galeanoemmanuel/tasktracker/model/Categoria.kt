package main.kotlin.com.galeanoemmanuel.tasktracker.model

class Categoria(
    val id: Int,
    val nombre: String,
    val descripcion: String
) {
    fun mostrarInfo(): String = "$nombre — $descripcion"
}