package com.example.apicheck.DataClass

data class Artists(
    val items: List<Item>,
    val pagingInfo: PagingInfo,
    val totalCount: Int
)