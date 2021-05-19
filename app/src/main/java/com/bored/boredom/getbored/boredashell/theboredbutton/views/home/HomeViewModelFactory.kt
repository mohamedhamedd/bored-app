package com.bored.boredom.getbored.boredashell.theboredbutton.views.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bored.boredom.getbored.boredashell.theboredbutton.data.repo.RepoHome

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory (private val repo: RepoHome
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(
            repo
        ) as T
    }

}