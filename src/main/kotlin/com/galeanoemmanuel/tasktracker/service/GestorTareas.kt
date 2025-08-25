package main.kotlin.com.galeanoemmanuel.tasktracker.service

import main.kotlin.com.galeanoemmanuel.tasktracker.model.Tarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.EstadoTarea

/**
 * Servicio de gestión de tareas (lógica de negocio).
 * Permite agregar, listar por estado (o todas), y cambiar el estado por id.
 */

class GestorTareas {
    private val tareas = mutableListOf<Tarea>()

    fun agregarTarea(tarea: Tarea): Boolean {

    // Cree esto opcionalmente para evitar IDs duplicados
    if (tareas.any { it.id == tarea.id }) {
        return false
        }
        tareas.add(tarea)
    return true
    }

    fun obtenerTodas(): List<Tarea> = tareas.toList()

    fun listarPorEstado(estado: EstadoTarea?): List<Tarea> =
        if (estado == null) tareas.toList() else tareas.filter { it.estado == estado }

    fun cambiarEstado(id: Int, nuevo: EstadoTarea): Boolean {
        val t = tareas.find { it.id == id } ?: return false
        t.cambiarEstado(nuevo)
        return true
    }
}