package src

// Declaración de funciones a nivel de archivo
fun registrarGasto(
    conceptos: MutableList<String>,
    categorias: MutableList<String>,
    montos: MutableList<Double>
) {
    val categoriasDisponibles = listOf("Comida", "Transporte", "Entretenimiento", "Servicios", "Otros")

    // 1. Solicita concepto
    print("Ingrese el concepto del gasto: ")
    var concepto = readlnOrNull()?.trim() ?: ""
    while (concepto.isEmpty()) {
        print("El concepto no puede estar vacío. Ingrese el concepto: ")
        concepto = readlnOrNull()?.trim() ?: ""
    }

    // Mostrar y validar categoría
    println("\nCategorías disponibles:")
    for ((index, cat) in categoriasDisponibles.withIndex()) {
        println("${index + 1}. $cat")
    }

    var categoriaSeleccionada = ""
    while (categoriaSeleccionada.isEmpty()) {
        print("Seleccione el número de la categoría: ")
        val opcion = readlnOrNull()?.toIntOrNull()
        if (opcion != null && opcion in 1..categoriasDisponibles.size) {
            categoriaSeleccionada = categoriasDisponibles[opcion - 1]
        } else {
            println("Opción no válida. Intente de nuevo.")
        }
    }

    // 3. Solicitar y validar monto (mayor a 0)
    var monto: Double? = null
    while (monto == null) {
        print("Ingrese el monto del gasto: ")
        val entrada = readlnOrNull()?.toDoubleOrNull()
        if (entrada != null && entrada > 0) {
            monto = entrada
        } else {
            println("El monto debe ser un número mayor a cero.")
        }
    }

    // Agregar a las tres listas
    conceptos.add(concepto)
    categorias.add(categoriaSeleccionada)
    montos.add(monto)

    // Desplegar la tabla formateada inmediatamente
    mostrarGastos(conceptos, categorias, montos)
}

fun mostrarGastos(
    conceptos: List<String>,
    categorias: List<String>,
    montos: List<Double>
) {
    if (conceptos.isEmpty()) {
        println("\nNo hay gastos registrados.")
        return
    }

    println("\n=== Lista de Gastos ===")
    var total = 0.0
    for (i in conceptos.indices) {
        println("${i + 1}. ${conceptos[i]} | Categoría: ${categorias[i]} | Monto: $${"%.2f".format(montos[i])}")
        total += montos[i]
    }
    println("-----------------------")
    println("Total gastado: $${"%.2f".format(total)}\n")
}

// Punto de entrada principal
fun main() {
    println("Gestor semanal de gastos\n")

    val conceptos = mutableListOf<String>()
    val categorias = mutableListOf<String>()
    val montos = mutableListOf<Double>()

    // Solicitar y validar la cantidad de gastos a registrar
    var cantidadGastos: Int? = null
    while (cantidadGastos == null || cantidadGastos <= 0) {
        print("¿Cuántos gastos desea registrar?: ")
        val entrada = readlnOrNull()?.toIntOrNull()
        if (entrada != null && entrada > 0) {
            cantidadGastos = entrada
        } else {
            println("Por favor, ingrese un número entero mayor a cero.")
        }
    }

    // Ciclo dinámico según el número ingresado por el usuario
    for (i in 1..cantidadGastos) {
        println("\n--- Registrando gasto $i de $cantidadGastos ---")
        registrarGasto(conceptos, categorias, montos)
    }
}