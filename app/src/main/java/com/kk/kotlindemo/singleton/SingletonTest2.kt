package com.kk.kotlindemo.singleton

/**
 * @author: kk
 * @date: 2023/6/20
 * 玄幻代码，切勿乱改
 * 伴生对象 double check
 */
class SingletonTest2 private constructor(name: String) {

    companion object {
        @Volatile
        private var INSTANCE: SingletonTest2? = null

        fun getInstance(name: String): SingletonTest2 =
            // 第一次判空
            INSTANCE ?: synchronized(this) {
                // 第二次判空
                INSTANCE ?: SingletonTest2(name).also { INSTANCE = it }
            }
    }

}