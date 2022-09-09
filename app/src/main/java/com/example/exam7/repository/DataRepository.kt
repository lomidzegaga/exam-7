package com.example.exam7.repository

import com.example.exam7.common.resource.Resource
import com.example.exam7.model.RecycleData
import com.example.exam7.remote.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val api: ApiService
) {

    suspend fun getVerticalData(): Resource<RecycleData.ActiveCourse> {
        return try {
            val response = api.getVerticalData()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.success(result)
            } else {
                Resource.error(response.message())
            }
        } catch (e: Exception) {
            Resource.error(e.message.toString())
        }
    }

    suspend fun getHorizontalData(): Resource<RecycleData.NewCourse> {
        return try {
            val response = api.getHorizontalData()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.success(result)
            } else {
                Resource.error(response.message())
            }
        } catch (e: Exception) {
            Resource.error(e.message.toString())

        }
    }
}
