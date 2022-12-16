package me.samuki.core.database.converters

import com.squareup.sqldelight.ColumnAdapter
import me.samuki.core.domain.StageType

class StageTypeAdapter : ColumnAdapter<StageType, String> {
    override fun decode(databaseValue: String): StageType = StageType.valueOf(databaseValue)

    override fun encode(value: StageType): String = value.name
}
