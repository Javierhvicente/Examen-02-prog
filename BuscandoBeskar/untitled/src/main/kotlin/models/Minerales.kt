package models

class Minerales(var valor: Int = (10..50).random(), val tipo: Type){
    companion object{
        fun random(): Minerales {
            val rand = (0..100).random()
            return when{
                rand < 20 -> Minerales((10..50).random(), Type.PURA)
                rand in (20..60) -> Minerales((10..50).random(), Type.MEZCLA)
                else -> {Minerales((10..50).random(), Type.CORROMPIDA)}
            }

        }

        enum class Type{
            PURA, MEZCLA, CORROMPIDA
        }
    }
}