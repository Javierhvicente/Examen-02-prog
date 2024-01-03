package models

import java.io.Serializable

const val CANTIDAD_MINERAL = 10
const val CANTIDAD_ROCAS = 8
const val MAX_TIME = 30_000// todo cambiar tiempo para pos produccion
class Terreno (configuration: Configuration) {
    val map = Array(configuration.numFilas){ arrayOfNulls<Any>(configuration.numColumnas)}
    val minerales = Minerales.random()
    var time = 0
    val sonda = Sonda()
    var mineralesObtenidos = 0
    var sondeoExitoso = 0
    init {
        println("Colocando la sonda")
        map[2][2] = Sonda()
        inicializarMapa(map)
        printMap(map)
        simulacion()
        informeFinal()
    }

    /**
     * Muestra el informe final
     */
    private fun informeFinal() {
        println("Minerales obtenidos: $mineralesObtenidos")
        println("Sondeo exitoso: $sondeoExitoso")
    }

    private fun ordenacion(lista: Array<Int>) {
        var aux: Int
        for(i in 0 until lista.size){
            for(j in 0 until lista.size -1){
                if(lista[j] < lista[j + 1]){
                    aux = lista[j]
                    lista[j] = lista[j + 1]
                    lista[j +1] = aux
                }
            }
        }
    }

    /**
     * Muestra la posición de la sonda en el mapa
     * @param map El mapa donde se encuentra la sonda
     * @return la posición de la sonda
     */
    private fun posicionSonda(map: Array<Array<Any?>>): String {
        for(i in map.indices){
            for(j in map[i].indices){
                if(map[i][j] == Sonda()){
                    return "$i:$j"
                }
            }
        }
        return "Posicion no encontrada"
    }

    /**
     * Simulacion de la recogida de materiales que realiza la sonda en el mapa
     */
    fun simulacion(){
        do{
            println("tiempo: $time")
            posicionSonda(map)
            printMap(map)
            buscarMineral(map)
            Thread.sleep(1000)
            time+=1000
        }while (time < MAX_TIME && hayMinerales(map) )
    }

    /**
     * Busqueda de minerales en el mapa
     * @param map el mapa en el que se buscan minerales
     */
    private fun buscarMineral(map: Array<Array<Any?>>) {
       sonda.movimiento()
    }


    /**
     * Comprueba si hay minerales en el mapa
     * @param map El mapa en el que estan los minerales
     */
    private fun hayMinerales(map: Array<Array<Any?>>): Boolean {
        for(i in this.map.indices){
            for(j in map[i].indices){
                if(map[i][j] == Minerales) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * Inicializa el mapa añadiendo los minerales y las rocas
     * @param map el mapa donde se introducen los minerales y las rocas
     * @return el mapa
     */
    private fun inicializarMapa(map: Array<Array<Any?>>): Array<Array<Any?>>{
        var fila: Int
        var columna: Int
        repeat(CANTIDAD_ROCAS) {
            do {
                fila = (0..map.size -1).random()
                columna = (0..map.size -1).random()
            } while (map[fila][columna] != null)
            map[fila][columna] = Roca()
        }
        repeat(CANTIDAD_MINERAL){
            do{
                fila = (0..map.size -1).random()
                columna = (0..map.size -1).random()
            }while (map[fila][columna] != null)
            map[fila][columna] = minerales
        }
        return map
    }

    /**
     * Imprime el mapa
     * @param map el mapa a imprimir
     */
    private fun printMap(map: Array<Array<Any?>>){
        for(i in map.indices){
            for(j in map[i].indices){
                when(map[i][j]){
                    is Minerales -> print("[ 💎 ]")
                    is Sonda -> print("[ 🤖 ]")
                    is Roca -> print("[ 🪨 ]")
                    else -> print("[     ]")
                }
            }
            println()
        }
        println()
    }

}