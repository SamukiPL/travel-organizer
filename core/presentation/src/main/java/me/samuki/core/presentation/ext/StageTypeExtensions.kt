package me.samuki.core.presentation.ext

import me.samuki.core.model.StageType
import me.samuki.core.presentation.R

fun StageType.nameResource(): Int = when (this) {
    StageType.Road -> R.string.stage_type_road
    StageType.Stay -> R.string.stage_type_stay
}
