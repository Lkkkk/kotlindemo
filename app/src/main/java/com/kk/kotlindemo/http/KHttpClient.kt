package com.kk.kotlindemo.http

import Field
import GET
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @author: kk
 * @date: 2023/6/25
 * 玄幻代码，切勿乱改
 */
object KHttpClient{
    private var okHttpClient : OkHttpClient = OkHttpClient()
    private var gson: Gson = Gson()
    var baseUrl = "https://baseurl.com"
    fun <T> create (service: Class<T>):T{
        return Proxy.newProxyInstance(
            service.classLoader,
            arrayOf<Class<*>>(service)
        ) { proxy, method, args ->
            val annotations = method.annotations
            for (annotation in annotations) {
                if (annotation is GET) {
                    val url = baseUrl + annotation.value
                    return@newProxyInstance invoke(url, method, args!!)
                }
            }
            return@newProxyInstance null
        } as T
    }

    private fun invoke(path: String, method: Method, args: Array<Any>): Any? {
        if (method.parameterAnnotations.size != args.size) return null
        var url = path
        val parameterAnnotations = method.parameterAnnotations
        for (i in parameterAnnotations.indices){
            for (parameterAnnotation in parameterAnnotations[i]){
                if (parameterAnnotation is Field){
                    val key = parameterAnnotation.value
                    val value = args[i].toString()
                    if (!url.contains("?")){
                        url += "?$key=$value"
                    }else{
                        url += "&$key=$value"
                    }
                }
            }
        }
        val request = Request.Builder() .url(url) .build()
        val response = okHttpClient.newCall(request).execute()
        val genericReturnType = method.genericReturnType
        val body = response.body
        val json = body?.string()
        val result = gson.fromJson<Any?>(json, genericReturnType)
        return result
    }
}

fun main() {
    val api: ApiService = KHttpClient.create(ApiService::class.java)
    val data: RepoList = api.repos(lang = "Kotlin", since = "weekly")
    println(data)
}





