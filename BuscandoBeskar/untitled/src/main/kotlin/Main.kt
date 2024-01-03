import models.Configuration
import models.Sonda
import models.Terreno

fun main(args: Array<String>) {
    println("Bienvenido mando")
    val config = Configuration.fromArgs(args)
    val terreno = Terreno(Configuration())

}