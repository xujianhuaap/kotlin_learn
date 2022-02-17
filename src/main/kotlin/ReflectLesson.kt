import java.lang.reflect.*
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.javaMethod
import kotlin.reflect.jvm.javaType

fun main() {
    println("==== welcome to kotlin===")
//    Tool::class.declaredFunctions.forEach {
//        it.javaMethod?.genericReturnType?.also { type ->
//            println("method  [${it?.javaMethod?.name}],return type is 【$type】， ${getTypeName(type)} ")
//        }
//
//    }


    Tool::class.declaredFunctions.forEach {
        println("${it.typeParameters}")
    }

    var c = listOf<Any>()
    val c1 = listOf<Int>()


    val m1 = mutableListOf<Number>()

    m1.addAll(c1)


}


interface Tool<R, T,  W:Number> {
    fun adapt(r: R): T //TypeVariable
    fun adapt1(r: R): Array<T>//GenericArrayType
    fun adapt2(r: R): List<*> //ParameterizedType
    fun adapt3(r: R): Array<String>
    fun adapt4(r: R): String //RawType
}

//kotlin 不再支持WildcardType,但是有通配符号*
fun getTypeName(type: Type): String = when (type) {
    is TypeVariable<*> -> "TypeVariable"
    is WildcardType -> "WildCardType"
    is GenericArrayType -> "GenericArrayType"
    is ParameterizedType -> "ParameterType"
    is Class<*> -> "RawType"
    else -> ""
}