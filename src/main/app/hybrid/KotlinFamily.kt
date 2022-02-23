package hybrid

fun main() {
    println("=== welcome to kotlin and java ===")
    val arr = arrayOf(1,2,3)
    KotlinFamily.TAG

    unBox(Garden(Flower("Rose","red","good")))
    box(Living("tulip"))
}
class KotlinFamily {

    companion object {
        @JvmField
        val TAG = "KotlinFamily"
        const val VERSION = 1
    }

}

open class Living (val name:String)

open class Plant(name:String, val color:String):Living(name)

class Flower(name: String,color: String,val smell:String):Plant(name,color)

class Garden< L> (val living: L)

/***
 * 类型投影
 */
fun box(plant: Living):Garden<in Plant> = Garden(plant)
fun unBox(garden: Garden<out Plant>) : Living = garden.living