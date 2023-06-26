package com.kk.kotlindemo.textprocess

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * @author: kk
 * @date: 2023/6/20
 * 玄幻代码，切勿乱改
 */
class TextProcessV1 {

    @RequiresApi(Build.VERSION_CODES.N)
    fun processText(text:String):List<WordFreq>{
        val cleand = clean(text)
        val words = cleand.split(" ")
        val map = getWordCount(words)
        val list = sortByCount(map)
        return list
    }


    //标点符号转换成空格
    fun clean(text: String): String {
        return text.replace("[^A-Za-z]".toRegex(), " ")
            .trim()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getWordCount(list: List<String>): Map<String,Int> {
        val map = hashMapOf<String,Int>()
        for (wold in list){
            if (wold=="")continue
            var trim = wold.trim()
            var count = map.getOrDefault(trim,0)
            map[trim] = count+1
        }
        return map
    }

   fun sortByCount(map:Map<String,Int>):MutableList<WordFreq>{
       val list = mutableListOf<WordFreq>()
        for (entry in map){
            if (entry.key=="")continue
            var freq = WordFreq(entry.key,entry.value)
            list.add(freq)
        }
       //按照count排序
       list.sortByDescending { it.count}
       return list
   }
}

data class WordFreq(val word:String,val count:Int)