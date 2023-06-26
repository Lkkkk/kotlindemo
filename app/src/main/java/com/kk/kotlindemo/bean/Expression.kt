package com.kk.kotlindemo.bean

import com.kk.kotlindemo.calculate.Operation

/**
 * @author: kk
 * @date: 2023/2/14
 * 玄幻代码，切勿乱改
 */
data class Expression (
    val left:String,
    val operation: Operation,
    val right:String
)