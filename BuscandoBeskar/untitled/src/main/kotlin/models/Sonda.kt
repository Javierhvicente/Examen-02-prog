package models

class Sonda(var fila: Int = 2, var columna: Int = 2){
    /**
     * Movimiento que realiza la sonda en el mapa
     */
     fun movimiento() {
        val direccion = nuevaDireccion()
        val nuevaFila = fila + direccion[0]
        val nuevaCol = columna + direccion[1]
        this.fila = nuevaFila
        this.columna = nuevaCol
    }

    /**
     * Crea una nueva direccion para la sonda
     * @return la nueva direccion
     */
    private fun nuevaDireccion(): Array<Int> {
        var nuevaDirFil = 0
        var nuevaDirCol = 0
        do{
            nuevaDirFil = arrayOf(-1, 0, 1).random()
            nuevaDirCol = arrayOf(-1, 0, 1).random()
        }while (nuevaDirFil != 0 && nuevaDirCol != 0)
        return arrayOf(nuevaDirFil, nuevaDirCol)
    }
}