package com.kk.kotlindemo.http

/**
 * @author: kk
 * @date: 2023/6/25
 * 玄幻代码，切勿乱改
 */

data class RepoList(
    var count: Int?,
    var items: List<Repo>?,
    var msg: String?
)

data class Repo (
    var added_stars: String?,
    var avatars: List<String>?,
    var desc: String?,
    var forks: String?,
    var lang: String?,
    var repo: String?,
    var repo_link: String?,
    var stars: String?
)