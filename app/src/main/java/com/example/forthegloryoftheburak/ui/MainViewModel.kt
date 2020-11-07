package com.example.forthegloryoftheburak.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forthegloryoftheburak.data.model.Rocket
import com.example.forthegloryoftheburak.data.model.Rocket2
import com.example.forthegloryoftheburak.data.repository.SpaceXRepository
import com.example.forthegloryoftheburak.util.loge
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class MainViewModel(private val repository: SpaceXRepository) : ViewModel() {
    val rockets: ArrayList<Rocket> = arrayListOf()
    val rockets2: ArrayList<Response<List<Rocket2>>> = arrayListOf()
    fun getRockets() {
        viewModelScope.launch {
            val request1 = async {
                try {
                    delay(3000)
                    repeat(3) {
                        rockets.addAll(repository.getRockets())
                    }
                } catch (e: Exception) {
                    println("Network error :[")
                    return@async
                }
            }

            val request2 = async {
                try {
                    repeat(4) {
                        rockets2.add(repository.getRockets2())
                    }
                } catch (e: Exception) {
                    println("Network error :[")
                    return@async
                }
            }

            request2.await()
            print()

            request1.await()
            print()
        }
    }

    private fun print(){
        Log.e("keko", "keko")
        rockets.forEach(::loge)
        rockets2.forEach {
            if (it.code() == 200) {
                it.body()?.forEach(::loge)
            }
        }
    }

    fun getRockets2() {
        runBlocking {
            delay(3000)
            val response: Response<List<Rocket2>> = try {
                repository.getRockets2()
            } catch (e: Exception) {
                println("Network error :[")
                return@runBlocking
            }

            if (response.code() == 200) {
                response.body()?.forEach(::loge)
            }
        }

        runBlocking {
            val rockets: List<Rocket> = try {
                repository.getRockets()
            } catch (e: Exception) {
                println("Network error :[")
                return@runBlocking
            }
            rockets.forEach(::loge)
        }
    }
}