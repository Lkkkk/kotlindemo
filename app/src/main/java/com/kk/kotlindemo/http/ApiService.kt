package com.kk.kotlindemo.http

import Field
import GET

/**
 * @author: kk
 * @date: 2023/6/25
 * 玄幻代码，切勿乱改
 */

interface ApiService {
    @GET("/repo")
    fun repos(
        @Field("lang") lang: String,
        @Field("since") since: String
    ): RepoList
}

