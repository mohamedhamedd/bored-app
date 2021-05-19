package com.bored.boredom.getbored.boredashell.theboredbutton.views.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bored.boredom.getbored.boredashell.theboredbutton.data.repo.RepoHome
import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.Coroutines
import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.NoInternetException
import java.lang.Exception

class HomeViewModel(private val repoHome: RepoHome) : ViewModel() {


    var iHomeInterface: IHomeInterface? = null
    var IProperties: IProperties? = null
    var mLink = MutableLiveData<String>()

    fun getActivity() {

        Coroutines.main {

            try {
                iHomeInterface?.onStarted()
                val response = repoHome.getActivity()
                if (response.isSuccessful) {

                    val type = response.body()?.type
                    val accessibility = response.body()?.accessibility?.times(100)
                    val activity = response.body()?.activity
                    mLink.value = response.body()?.link
                    val participants = response.body()?.participants
                    val price = response.body()?.price?.times(100)

                    iHomeInterface?.onSuccess(
                        type = type,
                        accessibility = accessibility,
                        price = price,
                        participants = participants,
                        activity = activity
                    )

                } else {
                    iHomeInterface?.onFailure(response.message().toString())
                }
            } catch (ex: Exception) {
                iHomeInterface?.onFailure(ex.message.toString())
            } catch (ex: NoInternetException) {
                iHomeInterface?.onFailure(ex.message.toString())
            }


        }


    }

    fun getLink() {

        if (mLink.value.isNullOrEmpty()) {
            IProperties?.onNull("No Link")
        } else {
            IProperties?.onHasLink(mLink.value.toString())
        }

    }

    fun openActivity(){
        IProperties?.openVideos()
    }

}