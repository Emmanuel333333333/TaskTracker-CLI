package main.kotlin.com.galeanoemmanuel.tasktracker

import main.kotlin.com.galeanoemmanuel.tasktracker.model.Categoria
import main.kotlin.com.galeanoemmanuel.tasktracker.model.Tarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.EstadoTarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.Prioridad

/**
 * Main de la aplicación.
 * Fase básica + desafíos (categoría y prioridad).
 */
fun main() {
    // Categorías
    val cat1 = Categoria(1, "Escuela", "Tareas académicas")
    val cat2 = Categoria(2, "Trabajo", "Tareas laborales")

    // Crear tareas
    val tarea1 = Tarea(1, "Test", "Descripción", EstadoTarea.PENDIENTE, "19/12/2024", Prioridad.MEDIA, cat1)
    val tarea2 = Tarea(2, "Aprender Kotlin", "Descripción", EstadoTarea.PENDIENTE, "20/08/2025", Prioridad.ALTA, cat2)
    val tarea3 = Tarea(3, "Aprender C#", "Descripción", EstadoTarea.EN_PROGRESO, "15/09/2024", Prioridad.BAJA, cat1)
    val tarea4 = Tarea(4, "Estudiar para el examen", "Descripción", EstadoTarea.PENDIENTE, "22/08/2025", Prioridad.ALTA, cat1)

    // Cambiar estado de algunas tareas (según la guía)
    tarea2.cambiarEstado(EstadoTarea.COMPLETADA)
    tarea3.cambiarEstado(EstadoTarea.EN_PROGRESO)
    tarea4.cambiarEstado(EstadoTarea.COMPLETADA)

    // Mostrar todas las tareas
    println("📋 Lista de tareas:\n")
    val tareas = listOf(tarea1, tarea2, tarea3, tarea4)
    for (t in tareas) {
        println(t.mostrarInfo())
        println("----------------------------------------------------")
    }
}
