package com.kk.kotlindemo.singleton

/**
 * @author: kk
 * @date: 2023/6/20
 * 玄幻代码，切勿乱改
 */
class SingletonTest private constructor(name: String) {

    //伴生对象
    companion object : BaseSingleton<String, SingletonTest>() {
//        override fun creator(param: String): SingletonTest = SingletonTest(param)
        override val creator = ::SingletonTest
    }
}