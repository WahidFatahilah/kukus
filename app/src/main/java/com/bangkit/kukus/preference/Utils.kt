package com.bangkit.kukus.preference

import android.content.Context
import android.text.Editable

private lateinit var preferenceManager: PreferenceManager

object Utils {

    fun putPreferenceString(context: Context, key: String, value: String) {
        preferenceManager = PreferenceManager(context)
        preferenceManager.putString(key, value)
    }

    fun getPreferenceString(context: Context, key: String): String {
        preferenceManager = PreferenceManager(context)
        return preferenceManager.getString(key)
    }

    fun putPreferenceInt(context: Context, key: String, value: Int) {
        preferenceManager = PreferenceManager(context)
        preferenceManager.putInt(key, value)
    }

    fun getPreferenceInt(context: Context, key: String): Int {
        preferenceManager = PreferenceManager(context)
        return preferenceManager.getInt(key)
    }

    fun putPreferenceFloat(context: Context, key: String, value: Float) {
        preferenceManager = PreferenceManager(context)
        preferenceManager.putFloat(key, value)
    }

    fun getPreferenceFloat(context: Context, key: String): Float {
        preferenceManager = PreferenceManager(context)
        return preferenceManager.getFloat(key)
    }

    fun clearSinglePreference(context: Context, key: String) {
        preferenceManager = PreferenceManager(context)
        return preferenceManager.removeSinglePreference(key)
    }

    fun removePreference(context: Context) {
        preferenceManager = PreferenceManager(context)
        return preferenceManager.clearPreference()
    }
}