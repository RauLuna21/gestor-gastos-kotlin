package src

// 1. Declaración de funciones a nivel de archivo
fun registrarGasto(
    conceptos: MutableList<String>,
    categorias: MutableList<String>,
    montos: MutableList<Double>
) {

}

fun mostrarGastos(
    conceptos: List<String>,
    categorias: List<String>,
    montos: List<Double>
) {

}

// 2. Punto de entrada principal
fun main() {
    println("Gestor semanal de gastos")

    // Listas para almacenar los datos
    val conceptos = mutableListOf<String>()
    val categorias = mutableListOf<String>()
    val montos = mutableListOf<Double>()

    // Ejemplo de uso: Registrar 2 gastos y mostrarlos
    registrarGasto(conceptos, categorias, montos)
    registrarGasto(conceptos, categorias, montos)

    mostrarGastos(conceptos, categorias, montos)
}

