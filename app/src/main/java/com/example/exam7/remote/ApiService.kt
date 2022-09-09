package com.example.exam7.remote

import com.example.exam7.common.constants.ApiEndPoints
import com.example.exam7.model.RecycleData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ApiEndPoints.END_POINT)
    suspend fun getVerticalData(): Response<RecycleData.ActiveCourse>

    @GET(ApiEndPoints.END_POINT)
    suspend fun getHorizontalData() : Response<RecycleData.NewCourse>

}