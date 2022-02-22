package reflect

import others.Constants
import kotlin.reflect.full.*

fun main() {
    println("=== welcome to Kotlin lesson ===")
    Plant<Any>("rose", "red").printInfo("")

    val clazz = Plant::class
    println("clazz typeParameters ${clazz.typeParameters}")
    println("clazz members ${clazz.members}")
    println("clazz member property ${clazz.memberProperties}")
    println("clazz declare member properties ${clazz.declaredMemberProperties}")
    println("clazz declaredMemberExtensionProperties ${clazz.memberExtensionProperties}")
    println("clazz declaredMemberExtensionFunctions ${clazz.declaredMemberExtensionFunctions}")


    println("clazz functions ${clazz.functions}")
    println("clazz memberFunctions ${clazz.memberFunctions}")
    println("clazz memberExtensionFunctions ${clazz.memberExtensionFunctions}")

    println("clazz companionObject ${clazz.companionObject?.memberProperties}")

    println(
        "clazz isAbstract ${clazz.isAbstract}, isOpen ${clazz.isOpen}, isFinal ${clazz.isFinal}, " +
                "isData ${clazz.isData},isCompanion ${clazz.isCompanion}"
    )



    println("object class reflect.Rose property ${Rose::class.objectInstance}")
    println("top level const ${::VERSION}")
    println("top level function ${::printVersion}")

    println("${Constants::class.staticProperties}")
}


open class Living(val name: String)

class ReflectInfo(var info: String?) {

}

class Plant<out E>(name: String, var color: String) : Living(name) {
    fun printInfo(any: Any?) {
        println("$name-$color-$any")
    }

    var ReflectInfo.nonNullInfo
        get() = this.info
        set(value) {
            if (value == null) this.info = "default" else this.info = value
        }

    fun ReflectInfo.printReflectInfo() {
        printInfo(this.info)
    }

    companion object {
        const val TAG = "plant"

    }
}


object Rose{
    const val name:String = ""

}

const val VERSION = "123"

fun printVersion() {
    println(VERSION)
}