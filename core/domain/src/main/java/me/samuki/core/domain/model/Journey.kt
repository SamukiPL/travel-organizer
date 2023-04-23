package me.samuki.core.domain.model

import kotlinx.datetime.LocalDateTime
import me.samuki.core.model.Id


data class Journey(
    val id: Id,
    val name: String,
    val lastRevision: LocalDateTime
)
