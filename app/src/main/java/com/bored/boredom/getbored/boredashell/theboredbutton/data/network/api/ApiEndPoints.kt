package com.bored.boredom.getbored.boredashell.theboredbutton.data.network.api

import com.bored.boredom.getbored.boredashell.theboredbutton.pojo.PActivity
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndPoints {

   @GET("activity/")
   suspend fun getActivity():Response<PActivity>

}