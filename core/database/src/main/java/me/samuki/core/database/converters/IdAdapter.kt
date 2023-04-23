package me.samuki.core.database.converters

import com.squareup.sqldelight.ColumnAdapter
import me.samuki.core.data.mapper.toId
import me.samuki.core.model.Id

class IdAdapter : ColumnAdapter<Id, String> {
    override fun decode(databaseValue: String): Id = databaseValue.toId()

    override fun encode(value: Id): String = value.toString()
}
