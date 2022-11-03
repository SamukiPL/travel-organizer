package me.samuki.journeyName.data.network

import me.samuki.journeyName.data.network.model.CreateJourneyResponse
import me.samuki.journeyName.data.network.model.EditNameResponse
import me.samuki.journeyName.data.network.model.JourneyNameRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface JourneyNameEndpoint {
    @POST("createJourney")
    fun createJourney(@Body body: JourneyNameRequest): CreateJourneyResponse

    @POST("journey/editName")
    fun editName(@Body body: JourneyNameRequest): EditNameResponse
}
