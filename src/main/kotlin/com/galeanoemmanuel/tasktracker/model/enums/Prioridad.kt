package main.kotlin.com.galeanoemmanuel.tasktracker.model.enums

enum class Prioridad(val descripcion: String, val simbolo: String) {
    BAJA("Baja prioridad", "🟢"),
    MEDIA("Prioridad media", "🟡"),
    ALTA("Alta prioridad", "🔴");

    fun mostrarPrioridad(): String = "$simbolo $descripcion"

    companion object {
        fun fromOrdinal(ordinal: Int): Prioridad? = values().getOrNull(ordinal)
    }
}