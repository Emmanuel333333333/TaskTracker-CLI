package main.kotlin.com.galeanoemmanuel.tasktracker

import main.kotlin.com.galeanoemmanuel.tasktracker.model.Categoria
import main.kotlin.com.galeanoemmanuel.tasktracker.model.Tarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.EstadoTarea
import main.kotlin.com.galeanoemmanuel.tasktracker.model.enums.Prioridad
import main.kotlin.com.galeanoemmanuel.tasktracker.service.GestorTareas
import main.kotlin.com.galeanoemmanuel.tasktracker.ui.Menu

/**
 * Main de la aplicación.
 * Por defecto ejecuta las pruebas pedidas en la guia.
 * CLI interactivo activado codigo al final para acceder al menu.
 */
fun main() {
    val gestor = GestorTareas()

    // Categorías si quieres crear más, solo crea más instancias con otro id
    val cat1 = Categoria(1, "Escuela", "Tareas académicas")
    val cat2 = Categoria(2, "Trabajo", "Tareas laborales")
    // Tareas
    val tarea1 = Tarea(1, "Test", "Descripción", EstadoTarea.PENDIENTE, "19/12/2024", Prioridad.MEDIA, cat1)
    val tarea2 = Tarea(2, "Aprender Kotlin", "Descripción", EstadoTarea.PENDIENTE, "20/08/2025", Prioridad.ALTA, cat2)

    // Agregar tareas al gestor
    gestor.agregarTarea(tarea1)
    gestor.agregarTarea(tarea2)

    // Cambiar estado de una tarea
    tarea2.cambiarEstado(EstadoTarea.COMPLETADA)

    // CLI interactivo
    Menu(gestor).iniciar()
}
