# 📌 Proyecto Task Tracker CLI en Kotlin
## ✍️ Autor: Emmanuel Galeano Martinez
### 🆔 Ficha: 3144587 ADSO

# 📖 Descripción

--- 

- Este proyecto implementa un sistema de gestión de tareas en la consola utilizando Kotlin.
- Permite crear, listar y actualizar tareas con estados, prioridades y categorías, aplicando los conceptos vistos en clase:

- ✨ Clases, objetos, data classes, enums, métodos y estructuras de control.

- El programa se ejecuta en consola mostrando resultados directamente, sin menú interactivo todavía.

# 🛠️ Funcionalidades principales

### ✅ Crear tarea

- Cada tarea tiene: id, título, descripción, estado, fecha de creación, prioridad y categoría.

- Se valida el título con un companion object dentro de la clase Tarea.

### 🔄 Cambiar estado de tarea

- Se actualiza el estado de una tarea existente usando el método cambiarEstado.

### 📋 Listar todas las tareas

- Se imprimen en consola con mostrarInfo().

# 🧩 Diseño del código
### 📂 Paquetes principales

- 📌 Main.kt → Punto de entrada del programa, crea varias tareas de prueba, cambia estados y las imprime en consola.

- 📦 model/ → Contiene las data classes (Tarea, Categoria) y los enums (EstadoTarea, Prioridad).

- 🛠️ utils/ → Contendrá utilidades como FechaHelper (pendiente de uso).

# 🔹 Conceptos aplicados

- 📝 Data Classes → Tarea y Categoria con propiedades y métodos (mostrarInfo, mostrarResumen).

- 🎯 Enums → EstadoTarea y Prioridad para manejar valores controlados.

- 🛡️ Companion Object → Constante y validación de título dentro de Tarea.

- 🔁 Estructuras de control → Uso de for para recorrer e imprimir las tareas.

- 📂 Encapsulamiento → Cada entidad está separada en su propio archivo y paquete.

# ▶️ Ejecución

- Abrir el proyecto en IntelliJ IDEA.

- Ejecutar Main.kt.

- Se mostrarán en consola las tareas de prueba creadas con su estado, prioridad y categoría.

# ✅ Justificación de diseño

- 📌 Se aplicaron las guías de clases, objetos y data classes en un caso práctico.

- 🟢 Los desafíos extra (prioridad y categoría) fueron implementados correctamente.

- ⏳ El menú interactivo (Menu) y la clase GestorTareas no se usan todavía, porque corresponden a la siguiente fase del proyecto.