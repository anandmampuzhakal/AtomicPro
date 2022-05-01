package com.atomicpro.anand.ui.main
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atomicpro.anand.model.SportViewData
import com.atomicpro.services.sports.ContentRepository
import kotlinx.coroutines.launch
import kotlin.random.Random as Random

class MainViewModel : ViewModel() {
    val quoteModel = MutableLiveData<SportViewData>()
    val isLoading = MutableLiveData<Boolean>()

    fun getFeaturedSports() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val list = ContentRepository().getFeaturedSports()
            val number = Random.nextInt((list.size - 1))
            isLoading.postValue(false)
            quoteModel.postValue(SportViewData(list[number].name, list[number].description))
        }
    }

}