package main.kotlin.com.galeanoemmanuel.tasktracker.utils

// Imports necesarios para manejo de fechas y horas
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Helper de fechas como singleton (object).
 * FORMATO_FECHA: "dd/MM/yyyy"
 * Métodos: obtenerFechaActual, obtenerHoraActual, formatearFechaHora.
 */
object FechaHelper {
    const val FORMATO_FECHA: String = "dd/MM/yyyy"

    fun obtenerFechaActual(): String {
        val formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA)
        return LocalDateTime.now().format(formatter)
    }

    fun obtenerHoraActual(): String {
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        return LocalDateTime.now().format(formatter)
    }

    fun formatearFechaHora(): String {
        val formatter = DateTimeFormatter.ofPattern("$FORMATO_FECHA HH:mm:ss")
        return LocalDateTime.now().format(formatter)
    }
}