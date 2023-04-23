package me.samuki.core.model


data class Id(
    private val value: String
) {
    override fun toString(): String = value
}
