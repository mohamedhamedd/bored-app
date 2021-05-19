package com.moapps.advicebestfriend.di

import android.app.Application
import com.bored.boredom.getbored.boredashell.theboredbutton.data.network.NetworkConnectionInterceptor
import com.bored.boredom.getbored.boredashell.theboredbutton.data.network.RetrofitClient
import com.bored.boredom.getbored.boredashell.theboredbutton.data.repo.RepoHome
import com.bored.boredom.getbored.boredashell.theboredbutton.views.home.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class DIKodein : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {

        import(androidXModule(this@DIKodein))

        //NetworkConnection
        bind() from singleton { NetworkConnectionInterceptor(instance()) }

        //API
        bind() from singleton { RetrofitClient(instance()) }

        //Repositories
        bind() from singleton { RepoHome(instance()) }

        //ViewModel Factory
        bind() from provider {
            HomeViewModelFactory(
                instance()
            )
        }

    }
}