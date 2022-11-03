package me.samuki.journeyName.presentation

import androidx.annotation.StringRes

internal enum class JourneyNameType(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val button: Int
) {
    New(
        title = R.string.new_journey_name_title,
        description = R.string.new_journey_name_description,
        button = R.string.new_journey_name_button
    ),
    Change(
        title = R.string.edit_journey_name_title,
        description = R.string.edit_journey_name_description,
        button = R.string.edit_journey_name_button
    )
}
