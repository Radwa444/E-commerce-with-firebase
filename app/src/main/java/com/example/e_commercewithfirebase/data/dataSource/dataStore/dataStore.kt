package com.example.e_commercewithfirebase.data.dataSource.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object DataStoreKeys {
    const val E_COMMERCE_PREFERENCE="E_commerce_preference"
}
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DataStoreKeys.E_COMMERCE_PREFERENCE)
