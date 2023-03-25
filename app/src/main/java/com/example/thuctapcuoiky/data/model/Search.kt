package com.example.thuctapcuoiky.data.model

sealed class Search(val itemType: ItemType) {
    data class Tag(val tag: String, val number: String) : Search(ItemType.TAG)

    enum class ItemType(val value: Int) {
        TAG(0)
    }
}