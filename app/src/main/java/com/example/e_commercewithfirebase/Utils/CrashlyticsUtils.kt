package com.example.e_commercewithfirebase.Utils

import com.google.firebase.crashlytics.FirebaseCrashlytics

object CrashlyticsUtils {
    fun sendLogToCrashlytics( mag: String,vararg keys: String){
        keys.forEach {key ->
            FirebaseCrashlytics.getInstance().setCustomKey(key,mag)
        }
        FirebaseCrashlytics.getInstance().recordException(CustomCrashlyticsLogException(mag))
    }

    fun sendLogToCrashlytics( mag: String,vararg keys: Pair< String, String>){
        keys.forEach {key ->
            FirebaseCrashlytics.getInstance().setCustomKey(key.first,key.second)
        }
        FirebaseCrashlytics.getInstance().recordException(CustomCrashlyticsLogException(mag))
    }
    inline fun<reified T: Exception> sendCustomLogToCrashlytics(msg: String,vararg keys: Pair<String, String>){
        keys.forEach{key->
            FirebaseCrashlytics.getInstance().setCustomKey(key.first,key.second)

        }
        val exception=T::class.java.getConstructor(String::class.java).newInstance(msg)
        FirebaseCrashlytics.getInstance().recordException(exception)
    }


}

class CustomCrashlyticsLogException(message: String): Exception(message)