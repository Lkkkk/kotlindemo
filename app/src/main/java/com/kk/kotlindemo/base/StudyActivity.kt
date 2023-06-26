package com.kk.kotlindemo.base

import com.kk.kotlindemo.bean.Person
import com.kk.kotlindemo.bean.User
import kotlin.collections.ArrayList

/**
 * @author: kk
 * @date: 2023/2/6
 * 玄幻代码，切勿乱改
 */

fun main() {

    //val声明 类似于java的final，
    // var声明的为可变变量，对应java的普通变量
    // 支持类型推导
    //kotlin中不存在int和Integer
    val id:Int = 10 //初始化指定类型
    var idCanNull:Int? //默认都为非空, 添加?声明可为空
    val idx = 3//初始化 自动识别类型
    var idxx = 3

    val id1: Int? = id
    val id2: Int? = id
    //比较值   包括string类型也是使用这种
    println(id1 == id2)
    //比较对象的引用，不等于使用!==
    println(id1 === id2)

 /*---------------------字符串--------------------*/
    var str1 = "test str"
    println("测试字符串的显示$id")
    println("测试字符串的显示2${id + idx}")
    val price = "${'$'}99.99"
    println(price)
    println("\$ $idxx")

    //定义原始文本，它定义的时候是什么格式，最终打印也会是对应的格式。不用像java一样添加+号和换行符
    val s = """
       当我们的字符串有复杂的格式时
       原始字符串非常的方便
       因为它可以做到所见即所得。 """
    print(s)

    //字符串判断的方法
//    isNullOrEmpty —— 为null或长度为0时返回true。
//    isNullOrBlank —— 为null或长度为0或者全是空格，返回true。
//    isEmpty —— 长度为0时返回true，必须先判断非null
//    isBlank —— 长度为0或者全是空格返回true，必须先判断非null
    str1.isEmpty()
    str1.isNullOrEmpty()

   /*----------------------数组-----------------------*/
    val strArray: Array<String> = arrayOf("1", "2", "3")
    val intArray: Array<Int> = arrayOf(1, 2, 3)
    val strArray2: ArrayList<String> = arrayListOf()
    strArray2.add("1")
    var strArray3: ArrayList<String> = arrayListOf()
    strArray3.add("1")

    //可变 可以增删改查 mutable
    var idList: MutableList<Int> = mutableListOf()
//    mutableListOf(1,2,3)

    var idMap: MutableMap<Int, String> = mutableMapOf()
//    mutableMapOf(1 to "id",2 to "name")
//    mutableMapOf(Pair(1,"id"),Pair(2,"name"))

    var idSet: MutableSet<Int> = mutableSetOf();

    //不可变
    var x1List: List<Double> = listOf()
    var x2Map: Map<Int, String> = mapOf()
    val x3Set: Set<String> = setOf()

    idList.add(110)
    idList.add(111)
    idList.add(112)

    //几种常规遍历
    for (id in idList) {
        println(id)
    }

    val iterator = idList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    //it代表内部元素
    idList.forEach { println("id value == ${it}") }

    // indices 表示userList的索引数组。这种方式本质上也是采用了for-in, 但遍历的是索引
    for (i in idList.indices) {
        val id = idList[i]
    }
    /*---------------控制语句------------------------------------------*/
    //kotlin中的elvis表达式
    //?: 表示一旦为空返回冒号后面的值，否则返回正常的值
    var result = idx?:-1

    if (id > idx) id else idx //带返回值

    //kotlin没有 switch case  只有when else
//    var count:Int = 0
//    btn_when_simple.setOnClickListener {
//        tv_answer.text = when (count) {
//            0 -> "值为0"
//            1 -> "值为1"
//            else -> "其他值"
//        }
//        count = (count+1) % 3
//    }

    //可以对条件进行区间判断和筛选
//    btn_when_region.setOnClickListener {
//        tv_answer.text = when (count) {
//            1,3,5,7,9 -> "取值为13579中的一个"
//            in 13..19 -> "取值为13到19中的一个"
//            !in 6..10 -> "取值不再6到10之间"
//            else -> "其他值"
//        }
//        count = (count+1) % 20
//    }

    // is 关键字等同于 java中的instance
//    var countType:Number;
//    tv_answer.text = when (countType) {
//        is Long -> "Long类型"
//        is Double -> "Double类型"
//        else -> "其他类型"
//    }

// for循环关键字  until setp downTo
    // 遍历11到66之间的数值，until 声明了一个左闭右开的区间——不包含66，包含11
    for (i in 11 until 66) {
    }
// 遍历23-89之间的数值，步进为4——每次+4。23..89声明一个左右均闭合的区间
    for (i in 23..89 step 4) {
    }
//倒序遍历从50到7
    for (i in 50 downTo 7) {
    }

    // while  do while 判断
//    btn_repeat_begin.setOnClickListener {
//        var poem:String=""
//        var i:Int = 0
//        while (i < poemArray.size) {
//            if (i%2 ==0) {
//                poem = "$poem${poemArray[i]}\n"
//            } else {
//                poem = "$poem${poemArray[i]}\n"
//            }
//            i++
//        }
//        poem = "${poem}该诗歌一共有${i}句"
//        tv_poem_content.text = poem
//    }
//
//    btn_repeat_end.setOnClickListener {
//        var poem:String=""
//        var i:Int = 0
//        do {
//            if (i%2 ==0) {
//                poem = "$poem${poemArray[i]}\n"
//            } else {
//                poem = "$poem${poemArray[i]}\n"
//            }
//            i++
//        } while (i < poemArray.size)
//        poem = "${poem}该诗歌一共有${i}句"
//        tv_poem_content.text = poem
//    }

//    使用 break——中断循环、continue——跳过本次循环，基本用法同Java，
//    另外，当嵌套循环时，还可以通过 @循环标签名 指定要中断的循环。
//    btn_repeat_break.setOnClickListener {
//        var i:Int = 0
//        var is_found = false
//// outsize@ 表示为外层循环添加标签，名称为 outside
//        outside@ while (i < poemArray.size) {
//            var j:Int = 0
//            var item = poemArray[i];
//            while ( j < item.length) {
//                if (item[j] == '一') {
//                    is_found = true
////中断标签名为outside的循环
//                    break@outside
//                }
//                j++
//            }
//            i++
//        }


    /*--------------对象------------------------------*/
   val user:User = User(id = 1,name="xixi",sex = "男")
    val user2:User = User(1,"xixi","男")
    val kk = Person( "kk",18, "china")
    val(name,age,address) = kk
    val kk2 = kk.copy(age = 19)
    println("kk2的姓名为${kk2.name}")

    //double
    var number: Double = 100.00
}

/*-------------------------函数--------------------------------*/
fun method1(name:String):String{
    return ""
}

//入参带默认值
fun method2(name:String,
            sex:String,
            address:String = "beijing"){
}

fun testAllMethod() {
    method1("kk")
    method1(name = "kk")//形参输入模式
    method2(name = "kk", sex = "男")
}

//T表示泛型
fun<T> subStr(title:String,vararg info:T?):String{
    var str:String = "$title:"
    for (item in info){
        //循环遍历拼接
        str = "$str ${item.toString()}"
    }
    return str
}
var str:String? = subStr<String>("一种几种颜色","红色","白色","黄色")
var str2:String =  subStr<Int>("几个数字",1,2,3)

//inline 关键字，常用于优化lambda表达式编译时生成匿名类带来的性能消耗上的优化，常规函数影响不大
//内联函数使用 inline 修饰符标记，内联函数在 被使用的时候编译器并不会生成函数调用的代码，
//而是使用函数实现的真实代码替换每一次的函数调用

inline fun <T> inlineTest(user: User,action: () -> T): T {
    user.Toast()
    try {
        return action()
    } finally {
        user.Toast2()
    }
}

fun function1(args: Array<String>) {
    println("执行 inlineTest 之前")
    val user:User = User(1,"xixi","男")
    inlineTest(user) {
        println("do cus action--inline")
    }
    println("执行 inlineTest 之后")
}

//编译后 替换了方法体，相当于以下效果
fun function2(args: Array<String>) {
    println("执行 inlineTest 之前")
    val user:User = User(1,"xixi","男")
    user.Toast()
    try {
        println("do cus action--inline")
    } finally {
        user.Toast2()
    }
    println("执行 inlineTest 之后")
}

// 具体化参数的内联函数用法
fun setArrayNumber(array:Array<Number>) {
    var str:String = "数组元素依次排列"
    for (item in array) {
        str = str + item.toString() + ", "
    }
    println(str)
}
//double int  long都继承自Number，一般来说可以调用此方法，实际使用发现会报错，kotlin要求参数类型完全一直
//可以改成这样
//fun前面加了inline表示内联函数, <reified param:Number> 表示param需要是 Number的子类
inline fun<reified param:Number> setArrayNumber2(array:Array<param>) {
    var str:String = "数组元素依次排列"
    for (item in array) {
        str = str + item.toString() + ", "
    }
    println(str)
}

//高阶函数
//高阶函数就是以另 一个函数作 为参数或者返回值的函数。
//greater函数接收两个参数，返回Boolean；
fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
    var max: T? = null
    for (item in array)
        if (max == null || greater(item, max))
            max = item
    return max
}
//此函数中  greater: (T, T) -> Boolean 作为入参，这种函数称为函数类型的变量，那么maxCustom函数就称为高阶函数


//evils表达式可简化代码
fun getLength(text: String?): Int { return if (text != null) text.length else 0}
fun getLength2(text: String?): Int {
    return text?.length ?: 0
}










