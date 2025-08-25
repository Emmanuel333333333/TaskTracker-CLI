# 📌 Proyecto Task Tracker CLI en Kotlin
## Autor: **Emmanuel Galeano Martinez** 
### Ficha: 3144587 ADSO

## 📖 Descripción
Este proyecto implementa un **sistema de gestión de tareas** en la consola utilizando **Kotlin**.  
Permite crear, listar y actualizar tareas con estados y categorías, siguiendo los conceptos vistos en clase sobre **clases, objetos, data classes, enums y estructuras de control**.

El programa está diseñado como un **CLI interactivo** que se repite hasta que el usuario decida salir.

---

## 🛠️ Funcionalidades principales
1. **Crear tarea**
    - Cada tarea tiene: `id`, `título`, `descripción`, `estado`, `fecha de creación` y los desafios `prioridad`, `categoría`.
    - Se valida que el título no exceda el máximo permitido y que el ID no esté repetido.

2. **Listar tareas por estado**
    - Estados disponibles: `PENDIENTE`, `EN_PROGRESO`, `COMPLETADA`.

3. **Cambiar estado de tarea**
    - Se actualiza el estado de una tarea existente.

4. **Listar todas las tareas**
    - Muestra todas las tareas con su información completa.

---

## 🧩 Diseño del código

### 📂 Paquetes principales
- `Main.kt` → **Punto de entrada del programa**, ya viene con algunas tareas y categorías predeterminadas para probar el sistema.
- `model/` → Contiene las **data classes** (`Tarea`, `Categoria`) y los **enums** (`EstadoTarea`, `Prioridad`).
- `service/` → Contiene el **GestorTareas**, que maneja la lógica del CRUD de tareas.
- `ui/` → Contiene el **Menu**, que implementa el CLI interactivo.
- `utils/` → Herramientas de apoyo como `FechaHelper`.

### 🔹 Conceptos aplicados
- **Clases y Objetos** → Uso de `GestorTareas` y `Menu` para organizar la lógica.
- **Data Classes** → Uso de `Tarea` y `Categoria` con sus propiedades y métodos (`mostrarInfo`, `mostrarResumen`).
- **Enums** → Manejo de `EstadoTarea` y `Prioridad`.
- **Companion Object** → Validación de títulos con constantes.
- **Estructuras de control** → Uso de `when` y `while` (según la guía de control de flujo).
- **Encapsulamiento** → Propiedades y métodos organizados en clases específicas.

---

## ▶️ Ejecución
1. Abrir el proyecto en **IntelliJ IDEA**.
2. Ejecutar `Main.kt`.
3. Se mostrará el menú interactivo:

---

## ✅ Justificación de diseño
- El `while` se utilizó en el menú porque está en la **guía de estructuras de control** y es necesario para que el CLI sea interactivo.
- Todo el proyecto sigue las **guías de clases, objetos y data classes**, aplicando sus conceptos en un caso práctico real.
- Se agregaron los **desafíos extra** (prioridad y categoría).

---