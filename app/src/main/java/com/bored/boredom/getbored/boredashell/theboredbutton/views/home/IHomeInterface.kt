package com.bored.boredom.getbored.boredashell.theboredbutton.views.home

interface IHomeInterface {
    fun onStarted()
    fun onSuccess(
        accessibility: Double?,
        activity: String?,
        participants: Int?,
        price: Double?,
        type: String?
    )
    fun onFailure(message: String)
}