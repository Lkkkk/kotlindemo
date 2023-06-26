package com.kk.kotlindemo.base

import com.kk.kotlindemo.singleton.SingletonTest2


/**
 * @author: kk
 * @date: 2023/6/19
 * 玄幻代码，切勿乱改
 * object关键词的使用
 */
class ObjectStudy {
    /*
    * 匿名内部类，单例模式 伴生对象
    * */
    fun main() {
        //匿名内部类，可以同时实现接口和继承,
        // 不需要单独定义类，直接使用就行
        val item = object : A, B, C() {

            override fun funA() {
                TODO("Not yet implemented")
            }

            override fun funB() {
                TODO("Not yet implemented")
            }

            override fun funC() {
                TODO("Not yet implemented")
            }
        }

        Car.test()
        //user对象的获取，单例中会懒加载执行获取网络请求和敏感词过滤的操作
        UserManager.user
        SingletonTest2.getInstance("Tom")
    }
}


interface A {
    fun funA()
}

interface B {
    fun funB()
}

abstract class C {
    abstract fun funC()
}

//单例模式
object Car {
    fun test() {
    }
}

//companion 关键字 伴生对象
class Home {
    companion object {
    }
}

//  私有的构造函数，外部无法调用
class User private constructor(name: String) {
    companion object {
        @JvmStatic
        fun create(name: String): User? {
            // 统一检查，比如敏感词过滤
            return User(name)
        }
    }
}

//懒加载单例
object UserManager {
    // 对外暴露的 user
    val user by lazy { loadUser() }

    private fun loadUser(): User? {
        // 从网络或者数据库加载数据
        return User.create("tom")
    }

    fun login() {}
}




