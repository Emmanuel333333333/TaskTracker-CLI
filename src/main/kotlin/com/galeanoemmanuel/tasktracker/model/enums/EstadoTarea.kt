package main.kotlin.com.galeanoemmanuel.tasktracker.model.enums

/**
 * Enum de estados para una Tarea.
 * Requisitos tomados de la guía del proyecto (descripcion, simbolo, mostrarEstado y fromOrdinal).
 */
enum class EstadoTarea(val descripcion: String, val simbolo: String) {
    PENDIENTE("Por hacer", "⏳"),
    EN_PROGRESO("En progreso", "🔄"),
    COMPLETADA("Completada", "✅");

    fun mostrarEstado(): String = "$simbolo $descripcion"

    companion object {
        /**
         * Devuelve el EstadoTarea correspondiente al ordinal dado, o null si está fuera de rango.
         */
        fun fromOrdinal(ordinal: Int): EstadoTarea? =
            values().getOrNull(ordinal)
    }
}