package me.samuki.core.data.mapper

import me.samuki.core.model.Id

fun String.toId() = Id(this)
