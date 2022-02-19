import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties

fun main() {
    println("=== welcome to Kotlin lesson ===")
    val clazz = Plant::class
    println("clazz typeParameters ${clazz.typeParameters}")
    println("clazz members ${clazz.members}")
    println("clazz member property ${clazz.memberProperties}")
    println("clazz declare member properties ${clazz.declaredMemberProperties}")

    println("clazz isAbstract ${clazz.isAbstract}, isOpen ${clazz.isOpen}, isFinal ${clazz.isFinal}, " +
            "isData ${clazz.isData},isCompanion ${clazz.isCompanion}")
}
class ReflectLessonForKClass {
}

open class Living(val name:String)
open class Plant <out E>(name:String,var color:String):Living(name){
    fun printInfo(any: Any?){
        println(any)
    }
    companion object {
        const val TAG = "plant"
    }
}