package com.gmail.apigeoneer.mymemory.models

data class MemoryCard (
        val identifier: Int,
        var isFceUp: Boolean = false,
        var isMatched: Boolean = false
)