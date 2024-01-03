package models

class Direccion (val fila: Int, val columna: Int) {
    companion object{
        fun random(): Direccion{
            var nuevaDirFila: Int
            var nuevaDirCol: Int
            do{
                nuevaDirFila = intArrayOf(-1,0, 1).random()
                nuevaDirCol = intArrayOf(-1, 0, 1).random()
            }while (nuevaDirFila != 0 || nuevaDirCol != 0)
            return Direccion(nuevaDirFila, nuevaDirCol)
        }
    }

}