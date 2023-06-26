package com.kk.kotlindemo.textprocess

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * @author: kk
 * @date: 2023/6/20
 * 玄幻代码，切勿乱改
 */
class TextProcessV2 {

    @RequiresApi(Build.VERSION_CODES.N)
    fun processText(text:String):List<WordFreq>{
        return text
            .clean()
            .split(" ")
            .getWordCount()
            .maptoList { WordFreq(it.key, it.value) }
            .sortedByDescending { it.count }
    }

    //标点符号转换成空格
    fun String.clean(): String {
        return this.replace("[^A-Za-z]".toRegex(), " ")
            .trim()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun List<String>.getWordCount(): Map<String,Int> {
        val map = hashMapOf<String,Int>()
        for (wold in this){
            if (wold=="")continue
            var trim = wold.trim()
            var count = map.getOrDefault(trim,0)
            map[trim] = count+1
        }
        return map
    }

    //inline关键字
    //inline 的作用其实就是将 inline 函数当中的代码拷贝到调用处。
    //只针对高阶函数有用
    private inline fun <T> Map<String,Int>
            .maptoList(transform:(Map.Entry<String,Int>) -> T):MutableList<T>{
        val list = mutableListOf<T>()
        for (entry in this) {
            val freq = transform(entry)
            list.add(freq)
        }
        return list
    }
}
