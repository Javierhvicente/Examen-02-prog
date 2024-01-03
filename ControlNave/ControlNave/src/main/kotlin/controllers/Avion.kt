package controllers

import models.SistemaControl
const val MAX_TIME = 30_000
class Avion () {
    val sistemaControl = SistemaControl()
    init {
        val velocidad = sistemaControl.velocidad
        val coordenadas = sistemaControl.coordenadas
        simulacion()
    }

    private fun simulacion() {
        var longitudActual = 0
        var latitudActual = 0
        var time = 0
        do{
            movimiento()
            Thread.sleep(1000)
            time+=1000

        }while (time < MAX_TIME)
    }

    private fun movimiento() {
        TODO("Not yet implemented")
    }

}