package main.kotlin.com.galeanoemmanuel.tasktracker.ui

import main.kotlin.com.galeanoemmanuel.tasktracker.model.Tarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.Categoria
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.EstadoTarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.Prioridad
import main.kotlin.com.galeanoemmanuel.tasktracker.service.GestorTareas
import main.kotlin.com.galeanoemmanuel.tasktracker.utils.FechaHelper

/**
 * CLI básico por consola.
 * Opciones: crear tarea, listar por estado, cambiar estado, listar todas salir.
 */
class Menu(private val gestor: GestorTareas) {

    fun iniciar() {
        // Usamos un while para que el menú se repita de forma interactiva
        // Hasta que el usuario decida salir (estructura de control básica).
        while (true) {
            println("=== Task Tracker CLI ===")
            println("1) Crear tarea")
            println("2) Listar tareas por estado")
            println("3) Cambiar estado de una tarea")
            println("4) Listar todas")
            println("0) Salir")
            print("Seleccione opción: ")
            when (readLine()?.trim()) {
                "1" -> crearTarea()
                "2" -> listarPorEstado()
                "3" -> cambiarEstado()
                "4" -> listarTodas()
                "0" -> {
                    println("¡Hasta luego!")
                    return
                }
                else -> println("Opción no válida.")
            }
            println()
        }
    }

    private fun crearTarea() {
        print("ID: ")
        val id = readLine()?.toIntOrNull()
        if (id == null) {
            println("ID inválido.")
            return
        }

        print("Título: ")
        val titulo = readLine()?.trim().orEmpty()
        if (!Tarea.validarTitulo(titulo)) {
            println("Título inválido (1..${Tarea.MAX_TITULO_LENGTH} caracteres).")
            return
        }

        print("Descripción: ")
        val descripcion = readLine()?.trim().orEmpty()

        println("Selecciona prioridad: 0) BAJA, 1) MEDIA, 2) ALTA")
        val prioridadOrdinal = readLine()?.toIntOrNull()
        val prioridad = prioridadOrdinal?.let { Prioridad.fromOrdinal(it) } ?: Prioridad.MEDIA

        print("ID categoría: ")
        val catId = readLine()?.toIntOrNull() ?: 0
        print("Nombre categoría: ")
        val catNombre = readLine()?.trim().orEmpty()
        print("Descripción categoría: ")
        val catDesc = readLine()?.trim().orEmpty()
        val categoria = Categoria(catId, catNombre, catDesc)

        val fecha = FechaHelper.obtenerFechaActual()
        val tarea = Tarea(id, titulo, descripcion, EstadoTarea.PENDIENTE, fecha, prioridad, categoria)
        // Resultado de agregar tarea
        if (gestor.agregarTarea(tarea)){
        println("Tarea creada correctamente.")
    } else {
            println("⚠ Ya existe una tarea con ese ID.")
        }
    }

    private fun listarPorEstado() {
        println("Estados: 0) PENDIENTE, 1) EN_PROGRESO, 2) COMPLETADA, otro: TODAS")
        print("Selecciona estado: ")
        val ordinal = readLine()?.toIntOrNull()
        val estado = ordinal?.let { EstadoTarea.fromOrdinal(it) }
        val lista = gestor.listarPorEstado(estado)
        if (lista.isEmpty()) {
            println("No hay tareas para mostrar.")
        } else {
            println("Lista de tareas:")
            println("----------------------------------------------------")
            lista.forEach {
                println(it.mostrarInfo())
                println("----------------------------------------------------")
            }
        }
    }

    private fun cambiarEstado() {
        print("ID de la tarea: ")
        val id = readLine()?.toIntOrNull()
        if (id == null) {
            println("ID inválido.")
            return
        }
        println("Nuevo estado: 0) PENDIENTE, 1) EN_PROGRESO, 2) COMPLETADA")
        val ordinal = readLine()?.toIntOrNull()
        val estado = ordinal?.let { EstadoTarea.fromOrdinal(it) }
        if (estado == null) {
            println("Estado inválido.")
            return
        }
        val ok = gestor.cambiarEstado(id, estado)
        println(if (ok) "Estado actualizado." else "No existe una tarea con ese ID.")
    }

    private fun listarTodas() {
        val lista = gestor.obtenerTodas()
        if (lista.isEmpty()) {
            println("No hay tareas para mostrar.")
        } else {
            println("Lista de tareas:")
            println("----------------------------------------------------")
            lista.forEach {
                println(it.mostrarInfo())
                println("----------------------------------------------------")
            }
        }
    }
}
