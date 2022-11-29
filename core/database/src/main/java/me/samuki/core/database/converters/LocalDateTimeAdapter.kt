package me.samuki.core.database.converters

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime

class LocalDateTimeAdapter : ColumnAdapter<LocalDateTime, String> {
    override fun decode(databaseValue: String): LocalDateTime = databaseValue.toLocalDateTime()

    override fun encode(value: LocalDateTime): String = value.toString()
}
