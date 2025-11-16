package com.example.nexdish.data.model

data class Restaurant(
    val name: String = "",
    val distance: Int = 0,     // 단위: 미터
    val time: Int = 0,         // 도보 이동 시간
    val rating: Double = 0.0,  // Google API 연동 시 사용
    val address: String = "",
    val imageUrl: String = ""
)
