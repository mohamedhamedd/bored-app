package com.bored.boredom.getbored.boredashell.theboredbutton.data.repo

import com.bored.boredom.getbored.boredashell.theboredbutton.data.network.RetrofitClient
import com.bored.boredom.getbored.boredashell.theboredbutton.data.network.api.ApiEndPoints

class RepoHome(private val retrofitClient: RetrofitClient) {

    suspend fun getActivity() = retrofitClient.getAPI(ApiEndPoints::class.java).getActivity()

}