package com.bored.boredom.getbored.boredashell.theboredbutton.data.network

import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.Credentials.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient(var networkConnectionInterceptor: NetworkConnectionInterceptor) {

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(networkConnectionInterceptor)

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
        .build()

    fun <T> getAPI(API: Class<T>): T {
        return retrofit.create(API)
    }

}