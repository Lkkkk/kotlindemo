package com.kk.kotlindemo.singleton

/**
 * @author: kk
 * @date: 2023/6/20
 * 玄幻代码，切勿乱改
 * 抽象类的单例模式
 */
abstract class BaseSingleton<in P, out T> {

    @Volatile
    private var instance: T? = null

//    protected abstract fun creator(param: P): T

    //高阶函数的形式
    protected abstract val creator: (P)->T

    fun getInstance(param: P): T =
        instance ?: synchronized(this) {
        instance ?: creator(param).also { instance = it }
    }
}