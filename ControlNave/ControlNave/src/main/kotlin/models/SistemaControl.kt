package models

import org.lighthousegames.logging.logging

private val log = logging()
class SistemaControl {
    val velocidad = introducirVelocidad()
    val coordenadas = pedirCoordenadas()
    fun introducirVelocidad(): Double {
        var inputOk = false
        var velocidad: Double
        do {
            println("Introduce la velocidad a la que quieres ir")
            velocidad = readln().toDoubleOrNull() ?: 0.0
            if (velocidad in (0.1..999.99)) {
                inputOk = true
            } else {
                inputOk = false
            }
        } while (!inputOk)
        return velocidad
    }

    fun pedirCoordenadas(): Array<Int> {
        var inputOk = false
        var coordenadas: Array<Int>
        var latitud: Int
        var longitud: Int
        do {
            println("Introduce la longitud y la latitud")
            println("Ejemplo:  350:200")
            println("La latitud y la longitud deben encontrarse entre 0 y 500")
            val input = readln().split(";")
            latitud = input[0].toIntOrNull() ?: -1
            longitud = input[1].toIntOrNull() ?: -1
            if (longitud > 0 && latitud > 0) {
                inputOk = true
            } else {
                inputOk = false
                ShowErrorMessage()
            }
        } while (!inputOk)
        return arrayOf(longitud, latitud)
    }

    private fun ShowErrorMessage() {
        println("Error de destino")
        println("Es necesario una longitud y una latitud")
        log.error { "Error de destino" }
    }


}

