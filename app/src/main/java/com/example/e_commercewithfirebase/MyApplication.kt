package com.example.e_commercewithfirebase

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        listenToNetworkConnectivity()

    }

    @SuppressLint("CheckResult")
    private fun listenToNetworkConnectivity() {
        ReactiveNetwork
            .observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                    isConnected: Boolean->
                Log.e(TAG,isConnected.toString())
                FirebaseCrashlytics.getInstance().setCustomKey("checked internet",isConnected)
            }



    }
    companion object{
        private const val TAG ="My App"
    }
}