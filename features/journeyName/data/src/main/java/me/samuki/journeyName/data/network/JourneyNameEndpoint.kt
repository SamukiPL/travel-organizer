package me.samuki.journeyName.data.network

import me.samuki.journeyName.data.network.model.JourneyNameResponse
import me.samuki.journeyName.data.network.model.JourneyNameRequest
import retrofit2.http.Body
import retrofit2.http.POST

internal interface JourneyNameEndpoint {
    @POST("createJourney")
    fun createJourney(@Body body: JourneyNameRequest): JourneyNameResponse

    @POST("journey/editName")
    fun editName(@Body body: JourneyNameRequest): JourneyNameResponse
}
