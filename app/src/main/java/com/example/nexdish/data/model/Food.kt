package com.example.nexdish.data.model

data class Food(
    val name: String = "",
    val type: String = "",       // 예: "한식", "양식", "디저트"
    val time: String = "",       // 예: "12:30 PM"
    val calories: Int = 0,       // 선택: 칼로리 정보
    val l1: String = "",         // L1~L4 카테고리 저장 가능
    val l2: String = "",
    val l3: String = "",
    val l4: String = ""
)
