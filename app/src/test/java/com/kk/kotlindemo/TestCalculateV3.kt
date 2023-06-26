package com.kk.kotlindemo

import com.kk.kotlindemo.calculate.CalculateV3
import org.junit.Test

/**
 * @author: kk
 * @date: 2023/2/14
 * 玄幻代码，切勿乱改
 */
class TestCalculateV3 {

    @Test
    fun testCalV3() {
        val calculateV3 = CalculateV3()
        val result = calculateV3.caculate("1+1")
        if (result == null) {
            println("输入格式有误")
        } else {
            println("${result.toInt() == 2}")
        }
    }
}