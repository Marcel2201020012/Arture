package com.example.arture.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import utils.PreferenceKey.STATUS_LOGIN_KEY

class DataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("StatusLogin")

        val USER_NAME_KEY = stringPreferencesKey("username")
    }

    //flow untuk status login
    val getStatusLogin: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[STATUS_LOGIN_KEY] ?: false
    }

    //flow untuk username
    val getUserName: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY]
    }

    suspend fun saveStatus(isLogin: Boolean) = context.dataStore.edit { preferences ->
        preferences[STATUS_LOGIN_KEY] = isLogin
    }

    suspend fun saveUserName(userName: String){
        context.dataStore.edit {preferences ->
            preferences[USER_NAME_KEY] = userName
        }
    }

    suspend fun clearStatus() = context.dataStore.edit { preferences ->
        preferences.remove(STATUS_LOGIN_KEY)
        preferences.remove(USER_NAME_KEY)
    }
}