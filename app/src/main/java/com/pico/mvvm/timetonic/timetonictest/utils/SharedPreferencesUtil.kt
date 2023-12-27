package com.pico.mvvm.timetonic.timetonictest.utils

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager

object SharedPreferencesUtil {
    fun saveToSharedPreferences(context: Context, key: String, value: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit {
            putString(key, value)
            apply()
        }
    }

    fun readFromSharedPreferences(context: Context, key: String, defaultValue: String): String {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }
}