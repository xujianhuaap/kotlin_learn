import java.lang.reflect.*
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.javaMethod

fun main() {
    println("==== welcome to kotlin===")

    println("===== java type =======")
    Tool::class.declaredFunctions.forEach {
        it.javaMethod?.genericReturnType?.also { type ->
            println("method  [${it?.javaMethod?.name}],return type is 【$type】， ${getTypeName(type)} ")
        }

    }

    println("==== kotlin reflect ===")

    Tool::class.declaredFunctions.forEach {
        val returnType = it.returnType
        val classifier = returnType.classifier
//        println(" $classifier ${classifier is KTypeParameter}")
        val arguments = returnType.arguments
        println(arguments)
    }


}


interface Tool<R, T,  W:Number> {
    fun adapt(r: R): T //TypeVariable
    fun adapt1(r: R): Array<T>//GenericArrayType
    fun adapt2(r: R): List<*> //ParameterizedType
    fun adapt3(r: R): Array<String>
    fun adapt4(r: R): String //RawType
    fun <K>adapt5(r:R):K
    fun <K>adapt6(r:R):W
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