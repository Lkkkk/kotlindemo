package com.kk.kotlindemo.base

import android.view.View
import android.widget.ImageView

/**
 * @author: kk
 * @date: 2023/6/20
 * 玄幻代码，切勿乱改
 * lamda表达式的演变过程示例
 */

lateinit var imageView: ImageView

fun main() {

    //第一种。匿名内部类object
    imageView.setOnClickListener(object : View.OnClickListener {
        override fun onClick(v: View?) {
            gotoPreview(v)
        }
    })

    //第二种，sam构造器  SAM Constructor
    imageView.setOnClickListener(View.OnClickListener { v: View? ->
        gotoPreview(v)
    })

    //第三种
    // 由于Kotlin的Lambda表达式是不需要 SAM Constructor 的，所以它也可以被删掉：
    imageView.setOnClickListener({ v: View? ->
        gotoPreview(v)
    })

    //第四种 kotlin支持类型推导 View类型也可以去掉
    imageView.setOnClickListener({ v ->
        gotoPreview(v)
    })

    //第五种  kotlin Lambda 表达式只有一个参数的时候，它可以被写成 it：
    imageView.setOnClickListener({ it ->
        gotoPreview(it)
    })

    //第六种 Kotlin Lambda 的 it 是可以被省略：
    imageView.setOnClickListener({
        gotoPreview(it)
    })

    //第七种 Kotlin Lambda 作为函数的最后一个参数时，Lambda 可以被挪到外面
    imageView.setOnClickListener() {
        gotoPreview(it)
    }

    //第八种 Kotlin 只有一个 Lambda 作为函数参数时，() 可以被省略
    imageView.setOnClickListener {
        gotoPreview(it)
    }
}

fun gotoPreview(view: View?) {

}