package cn.zhq.kotlindemo.logic

import androidx.lifecycle.liveData
import cn.zhq.kotlindemo.logic.model.Place
import cn.zhq.kotlindemo.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {

        val result = try {
            val searchPlaces = SunnyWeatherNetwork.searchPlaces(query)
            if (searchPlaces.status == "ok") {
                val places = searchPlaces.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is${searchPlaces.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}