package me.samuki.onboarding

import androidx.annotation.StringRes

enum class OnBoardingPage(val animation: String, @StringRes val title: Int, @StringRes val description: Int) {
    Welcome(
        animation = "animations/first_step.json",
        title = R.string.onboarding_welcome_title,
        description = R.string.onboarding_welcome_desc
    ),
    Collaborate(
        animation = "animations/second_step.json",
        title = R.string.onboarding_collaborate_title,
        description = R.string.onboarding_collaborate_desc
    ),
    Create(
        animation = "animations/third_step.json",
        title = R.string.onboarding_create_title,
        description = R.string.onboarding_create_desc
    ),
}
