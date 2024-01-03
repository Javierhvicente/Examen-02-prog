package models

import org.lighthousegames.logging.logging
import kotlin.system.exitProcess

private val log = logging()
class Configuration(val numFilas: Int = 5, val numColumnas: Int = 5){
    companion object {
        fun fromArgs(args: Array<String>): Any {
            if(args.size != 2){
                showErrorMessage()
            }
            val numFilas = args[0].trim().toIntOrNull() ?: -1
            val numColumnas = args[1].trim().toIntOrNull() ?: -1
            if(numFilas !in (5..7) || numColumnas !in (5..7)){
                showErrorMessage()
            }
            return Configuration(numFilas, numColumnas)
        }

        private fun showErrorMessage() {
            log.error { "Argumentos no válidos" }
            println("Argumentos inválidos")
            println("Usa: Java -jar BuscandoBeskar.jar <numFilas> <numColumnas>")
            println("Tanto las filas como las columnas deben de estar entre 5 y 7")
            exitProcess(-1)
        }
    }
}