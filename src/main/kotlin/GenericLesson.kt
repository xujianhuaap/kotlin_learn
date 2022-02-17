fun main() {
    println("=== welcome to kotlin generic lesson ===")
    val doubleSource = Source<Double>()
    val numberSource = Source<Number>()

    val t:Source<Double> = numberSource
    t.printInfo(0.0)

    val student = Student()
    val someBody = SomeBody()
    copyPerson(student,someBody)


    val lists = listOf(1)
    val mutableList = mutableListOf<Number>()

    //Collection< out E> 因此 addAll(Collection<E>) 这里可以使用协变
    mutableList.addAll(lists)

}

//类型参数设置边界
//类型参数 （out 或者 in)这种可以定义Source的时候添加，也可以使用的时候根据场景，在决定out 或者 in

/***
 * out 表示 Source 是 T的生产者，支持协变，Source<Base> 是Source<Derived>的父类
 * 是安全的。
 * in 表示Source 是 T 的消费者，支持逆变，Source<Base> 可以赋值给Source<Derived>是安全的.
 */
class Source<in T:Number>{
    fun printInfo(t:T){
        println(t)
    }
}



abstract class AbsInfo {
    fun print(info:String){
        println(info)
    }
}
open class Info:AbsInfo(){

}

class WorkInfo:Info(){

}


//类型参数添加约束
interface Person<I:AbsInfo>{
    fun set(info:I)

    fun getInfo():I
}

class Student():Person<WorkInfo>{
    override fun set(info: WorkInfo) {
        TODO("Not yet implemented")
    }

    override fun getInfo(): WorkInfo {
        TODO("Not yet implemented")
    }
}

class SomeBody:Person<AbsInfo>{
    override fun set(info: AbsInfo) {
        TODO("Not yet implemented")
    }

    override fun getInfo(): AbsInfo {
        TODO("Not yet implemented")
    }
}

//根据使用场景 制定用out 还是 in
fun copyPerson(from:Person<out Info>,to:Person<in Info>){
        to.set(from.getInfo())
        to.set(WorkInfo())
}