package com.example.bidikmimpi.data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// 1) Buat extension dataStore pada Context
private val Context.dataStore: androidx.datastore.core.DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

object SessionManager {
    private val TOKEN_KEY = stringPreferencesKey("auth_token")

    // 2) Fungsi untuk menyimpan token
    suspend fun saveAuthToken(context: Context, token: String) {
        context.dataStore.edit { prefs ->
            prefs[TOKEN_KEY] = token
        }
    }

    // 3) Fungsi untuk mengambil token
    fun getAuthToken(context: Context): Flow<String?> {
        return context.dataStore.data.map { prefs ->
            prefs[TOKEN_KEY]
        }
    }
}
