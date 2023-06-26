package com.kk.kotlindemo.base

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties

/**
 * @author: kk
 * @date: 2023/6/21
 * 玄幻代码，切勿乱改
 * 反射 实际使用中主要存在三个方面
 * 读取信息  修改信息  根据状态进行不同的处理逻辑
 */
fun main() {
    val student = Student("Tom", 99.5, 170)
    val school = School("PKU", "Beijing...")
    modifyAddressMember(school)
    readMembers(student)
    readMembers(school)
}

/* 要求readMembers函数能够输出以下内容：
Student.height=170
Student.name=Tom
Student.score=99.5
School.address=Beijing...
School.name=PKU

*/
//读取信息
fun readMembers(obj: Any) {
    // 读取obj的所有成员属性的名称和值
    // 扩展属性 memberProperties
    obj::class.memberProperties.forEach {
        println("${obj::class.simpleName}.${it.name}=${it.getter.call(obj)}")
    }
}

//修改信息
fun modifyAddressMember(obj: Any) {
    obj::class.memberProperties.forEach {
        if (it.name == "address"
            //判断属性是否可变，address 是用 var 修饰的，因此它的类型是 KMutableProperty1；
            && it is KMutableProperty1
            //setter 的参数个数应该是 2，第一个参数是 obj 自身，第二个是实际的值
            && it.setter.parameters.size == 2
            //getter 的返回值类型 returnType，来判断属性的类型是不是 String 类型
            && it.getter.returnType.classifier == String::class
        ) {
            it.setter.call(obj, "China")
            println("====Address changed.====")
        }
    }
}

//动态判断 据程序状态作出不同决策
fun modifyAddressMember2(obj: Any) {
    obj::class.memberProperties.forEach {
        if (it.name == "address"
            && it is KMutableProperty1
            && it.getter.returnType.classifier == String::class
        ) {
            it.setter.call(obj, "China")
            println("====Address changed.====")
        } else {
            // 差别在这里
            println("====Wrong type.====")
        }
    }
}


data class Student(
    val name: String,
    val score: Double,
    val height: Int
)

data class School(
    val name: String,
    var address: String
)