package me.samuki.core.domain.model

import kotlinx.datetime.LocalDateTime


data class Journey(
    val id: String,
    val name: String,
    val lastRevision: LocalDateTime
)
