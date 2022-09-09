package com.example.exam7.ui

import androidx.lifecycle.ViewModel
import com.example.exam7.common.resource.Resource
import com.example.exam7.model.RecycleData
import com.example.exam7.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    fun getVerticalItems(): Flow<Resource<RecycleData.ActiveCourse>> = flow {
        emit(dataRepository.getVerticalData())
    }

    fun getHorizontalItems() : Flow<Resource<RecycleData.NewCourse>> = flow {
        emit(dataRepository.getHorizontalData())
    }
}