package com.example.hackathoneonebite.Data

import java.io.Serializable
import java.time.LocalDateTime

data class Post(
    var imgArray: Array<String> = Array(4) {""}, // 이미지 URI 또는 파일 경로의 배열
    var id: String? = null,
    var likeCount: Int = 0,
    var date: LocalDateTime? = null,
    var message: String? = null,
    var frame: String? = null,
    var isFliped: Boolean = false
) : Serializable