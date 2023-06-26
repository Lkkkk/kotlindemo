package com.kk.kotlindemo.calculate

import com.kk.kotlindemo.bean.Expression
import kotlin.system.exitProcess

/*
* 大数量计算，采用位数遍历进位的方式进行累加
* 比如23338383+28388338
* */

fun main() {
    val calculateV3 = CalculateV3()
    calculateV3.start()
}


class CalculateV3 {
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

    fun addString(leftNumber: String, rightNumber: String): String {
//        val result = left.toInt() + right.toInt()
//        return result.toString()
        val result = StringBuilder()
        //代表两个数的位数，从个位开始计算
        var leftIndex = leftNumber.length - 1;
        var rightIndex = rightNumber.length - 1
        //进位数  比如9+4=13  那10位符的进位就为1
        var carray = 0;
        while (leftIndex >= 0 || rightIndex >= 0) {
            val leftVal = if (leftIndex >= 0) leftNumber.get(leftIndex).digitToInt() else 0
            val rightVal = if (rightIndex >= 0) rightNumber.get(rightIndex).digitToInt() else 0
            val sum = leftVal + rightVal + carray
            carray = sum / 10
            result.append(sum % 10)
            leftIndex--
            rightIndex--
        }
        if (carray != 0) {
            result.append(carray)
        }
        return result.reverse().toString()
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
        val operation2 = parseOperator(inputStr) ?: return null
        val inputList = inputStr.split(operation2.value)
        if (inputList.size != 2) return null
        return Expression(
            inputList[0].trim(),
            operation2,
            inputList[1].trim()
        )
    }

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