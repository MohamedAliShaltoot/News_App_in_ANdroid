package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.model.NewsRsponse
import com.example.retrofit.data.network.RetrtofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MAinViewModel : ViewModel() {


    private  val _newsResponse = MutableStateFlow<NewsRsponse?>(null)

    val newsResponse:StateFlow<NewsRsponse?> get()= _newsResponse

    val api = RetrtofitInstance.apiClient
    fun getNews(){
        viewModelScope.launch{
         val response = api.getEverything(q="tesla",apiKey="94b56b2444934387b5f55c8dd1150b99")
            if (response.isSuccessful){
                _newsResponse.value=response.body()
            }

        }
    }

}