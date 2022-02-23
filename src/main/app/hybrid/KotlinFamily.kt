package hybrid

fun main() {
    println("=== welcome to kotlin and java ===")
    val arr = arrayOf(1, 2, 3)
    KotlinFamily.TAG

    unBox(Garden(Flower("Rose", "red", "good")))
    box(Living("tulip"))
}

class KotlinFamily {

    companion object {
        @JvmField
        val TAG = "KotlinFamily"
        const val VERSION = 1
    }

}

open class Living(var name: String)

open class Plant(name: String, val color: String) : Living(name)

class Flower  @JvmOverloads constructor( name: String, color: String="red", val smell: String = "good") : Plant(name, color)

class Garden<L>(val living: L)

/***
 * 类型投影
 */
fun box(plant: Living): Garden<in Plant> = Garden(plant)
fun unBox(garden: Garden<out Plant>): Living = garden.living

/***
 * 协变与逆变
 * 类型参数边界
 */
 interface PlantManager<out T : Living, in D : Plant> {

    fun getLivingImpl(index: Int): T

    fun savePlant(d: D)
}

abstract class AbsPlantManager<T:Living>:PlantManager<T,Plant>{
    protected val sources = mutableListOf<Plant>()
    override fun savePlant(d: Plant) {
        sources.add(d)
    }


}
class FlowerManager: AbsPlantManager<Flower>() {

    override fun getLivingImpl(index: Int): Flower {
        return sources.filterIsInstance<Flower>()[index]
    }
}



