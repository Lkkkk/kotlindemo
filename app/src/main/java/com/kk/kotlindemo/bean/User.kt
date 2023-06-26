package com.kk.kotlindemo.bean

import android.widget.Toast

/**
 * @author: kk
 * @date: 2023/2/6
 * 玄幻代码，切勿乱改
 */

class User(
    id: Int,
    var name: String,
    sex: String
) {

    //kotlin中入参没有进行声明，则默认都是val的，表示初始化后无法被修改，不会存在java中的get和set方法
    //如果用var声明入参,则表示是可变的。

    //自定义getter属性
    val isKK
    get() = name.equals("kk")

    //getter方法增加逻辑计算的情况下，
    // 此时无法推导最后的结果是否为boolean还是其它的类型，所以要提前定义数据类型
    val iskknew: Boolean
        get() {
            var nameLength = name.length;
            return nameLength > 1 && name.equals("kk")
        }

   //setter方法，可以设置private属性，限制只能在对象类中调用
    var age: Int = 0
        set(value: Int) {
            field = value
        }

    var year: Int = 0
        set(value: Int) {
            field = value
        }

    //注意，无论是setter还是getter方法，它的作用范围只针对于最近的属性（按照由上而下的执行顺序）
    //比如上面同时定义了两个set方法，入参都是Int, 那么第一个set方法就作用于age属性。
    //需要把属性字段和离它最近的set方法看成一个整体模块


    // 主构造中的参数可以在init代码块中调用，也可以被类的属性调用
    init {
        println("类初始化，属性name值为${name}")
    }

    val key = name.toUpperCase();

    //次构造函数，类既有主构造 也有次构造 或者两者都没有

    fun Toast() {
        println("测试方法1")
    }

    fun Toast2() {
        println("测试方法2")
    }

    //嵌套类需要添加 inner关键字，否则类似于java的静态类，无法引用外部类的引用
    inner class b{
    }
}

//抽象类 添加open字段，
//类中的方法和字段如果没有添加open修饰字段的话，即使类被继承，也没办法去重写方法和属性
  open class Adult{
  }

/*---------------以下类为kotlin独有的类型--------------------*/

//数据类
data class Home(
    var title: String?,
    var address: String
)

data class Person(
    val name: String,
    val age: Int,
    val address: String
)

//主构造函数有注解或可⻅性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
//class Customer public @xx constructor(name: String) {
//}

//枚举类(有限的数据类型)
enum class Human{
    Man,Woman
}

//密封类，一种加强的枚举类

sealed class Result<out R> {
    data class Success<out T>(val data: T, val message: String = "") : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    data class Loading(val time: Long = System.currentTimeMillis()) : Result<Nothing>()
}