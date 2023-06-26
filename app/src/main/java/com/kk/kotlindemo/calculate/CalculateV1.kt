package com.kk.kotlindemo.calculate

import kotlin.system.exitProcess

/**
 * @author: kk
 * @date: 2023/2/13
 * 玄幻代码，切勿乱改
 * 简单计算器学习
 * 1.0版本 此版本的 Operation.valueOf(inputList[1])方法在枚举时会存在报错
 */

fun main() {
    val helpTip = """
        请输入标准的算式，并且按回车; 
        "比如：1 + 1，注意符合与数字之间要有空格。
        "输入exit，退出程序。
    """.trimIndent()

    while (true) {
        println(helpTip)
        val inputStr = readLine()?: continue
        if (inputStr == "exit") exitProcess(0)
        val inputList = inputStr.split(" ")
        val result = caculate(inputList)
        if (result==null){
            println("输入格式有误")
            continue
        }else{
            println("$inputStr=$result")
        }
    }
}

private fun caculate(inputList: List<String>): Int? {
    if (inputList.size != 3) return null
    val leftNumber = inputList[0].toInt()
    val operation = Operation.valueOf(inputList[1])
    val rightNumber = inputList[2].toInt()
    return when (operation) {
        Operation.ADD -> leftNumber + rightNumber
        Operation.MINUS -> leftNumber - rightNumber
        Operation.MULTI -> leftNumber * rightNumber
        Operation.DIVI -> leftNumber / rightNumber
    }
}

enum class Operation(val value: String) {
    ADD("+"),
    MINUS("-"),
    MULTI("*"),
    DIVI("/")
}




