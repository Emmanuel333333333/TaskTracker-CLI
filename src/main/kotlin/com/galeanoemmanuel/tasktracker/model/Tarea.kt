package main.kotlin.com.galeanoemmanuel.tasktracker.model

import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.EstadoTarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.Prioridad

/**
 * Data class de Tarea.
 * Cumple con: id (val), titulo/descripcion (var), estado: EstadoTarea (var, default PENDIENTE), fechaCreacion (val), prioridad: Prioridad (var, default MEDIA), categoria: Categoria (var).
 * Métodos: cambiarEstado, mostrarInfo, mostrarResumen.
 * Companion object: constante MAX_TITULO_LENGTH y validarTitulo.
 */

data class Tarea(
    val id: Int,
    var titulo: String,
    var descripcion: String,
    var estado: EstadoTarea = EstadoTarea.PENDIENTE,
    val fechaCreacion: String,
    var prioridad: Prioridad = Prioridad.MEDIA,
    var categoria: Categoria
) {
    fun cambiarEstado(nuevoEstado: EstadoTarea) {
        this.estado = nuevoEstado
    }

    fun mostrarInfo(): String = buildString {
        appendLine("ID: $id")
        appendLine("Título: $titulo")
        appendLine("Descripción: $descripcion")
        appendLine("Estado: ${estado.mostrarEstado()}")
        appendLine("Fecha de creación: $fechaCreacion")
        appendLine("Prioridad: ${prioridad.mostrarPrioridad()}")
        appendLine("Categoría: ${categoria.mostrarInfo()}")
    }

    fun mostrarResumen(): String =
        "[$id] $titulo — ${estado.mostrarEstado()} — ${prioridad.mostrarPrioridad()} — ${categoria.nombre}"

    companion object {
        const val MAX_TITULO_LENGTH: Int = 50

        fun validarTitulo(titulo: String): Boolean =
            titulo.isNotBlank() && titulo.length <= MAX_TITULO_LENGTH
    }
}
