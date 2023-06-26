package com.kk.kotlindemo.calculate

import com.kk.kotlindemo.bean.Expression
import kotlin.system.exitProcess

/*
* 2.0版本调用, 引入面向对象思想，
* 兼容输入格式,但未对输入内容做处理，比如分母为0的情况之类的
* */

fun main(){
    val calculateV2 = CalculateV2()
    calculateV2.start()
}


class CalculateV2 {
    fun start() {
        while (true) {
            val inputStr = readLine() ?: continue
            val result = caculate(inputStr)
            if (result == null) {
                println("输入格式有误")
                continue
            } else {
                println("$inputStr=$result")
            }
        }
    }

    /*
    *  val (left, operator, right) = expression
    *  等同于
    *  val.left = expression.left
    * val.operator = expression.operator
    * val.right = expression.right
    * */

    fun caculate(inputStr: String): String? {
        if (shouldExit(inputStr)) exitProcess(0)
        val expression = parseExpression(inputStr) ?: return null
        val (left, operator, right) = expression
        return when (operator) {
            Operation.ADD -> addString(left, right)
            Operation.MINUS -> minusString(left, right)
            Operation.MULTI -> multiString(left, right)
            Operation.DIVI -> diviString(left, right)
        }
    }

    fun addString(left: String, right: String): String {
        val result = left.toInt() + right.toInt()
        return result.toString()
    }

    fun minusString(left: String, right: String): String {
        val result = left.toInt() - right.toInt()
        return result.toString()
    }

    fun multiString(left: String, right: String): String {
        val result = left.toInt() * right.toInt()
        return result.toString()
    }

    fun diviString(left: String, right: String): String {
        val result = left.toInt() / right.toInt()
        return result.toString()
    }

    fun shouldExit(input: String): Boolean {
        return input == "exit"
    }

    fun parseExpression(inputStr: String): Expression? {
        val operation2 = parseOperator(inputStr)?:return null
        val inputList = inputStr.split(operation2.value)
        if (inputList.size!=2)return null
        return Expression(
            inputList[0].trim(),
            operation2,
            inputList[1].trim()
        )
    }

    //遍历获取运算类型
    fun parseOperator(inputStr: String): Operation? {
//        for (it in Operation2.values()){
//            if (input.contains(it.value)){
//                return it
//            }
//        }
        Operation.values().forEach {
            if (inputStr.contains(it.value)) {
                return it
            }
        }
        return null
    }
}