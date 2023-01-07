package me.samuki.core.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.boolean
import javax.inject.Inject

class WasOnBoardingSeen @Inject constructor(
    settings: Settings
) {
    var value by settings.boolean(WAS_ON_BOARDING_SEEN, false)

    companion object {
        private const val WAS_ON_BOARDING_SEEN = "WAS_ON_BOARDING_SEEN"
    }
}
