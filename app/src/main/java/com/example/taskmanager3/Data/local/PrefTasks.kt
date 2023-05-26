package com.example.taskmanager3.Data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.Uri

class PrefTasks(context: Context) {
    private val prefTasks = context.getSharedPreferences(SHARED_NAME, MODE_PRIVATE)
    fun isUserSeen(): Boolean {
        return prefTasks.getBoolean(SEEN_KEY, false)
    }

    fun userSeen() {
        prefTasks.edit().putBoolean(SEEN_KEY, true).apply()
    }

    fun isNameSaved(): String? {
        return prefTasks.getString(NAME_KEY, "")
    }

    fun nameSaved(name: String) {
        prefTasks.edit().putString(NAME_KEY, name).apply()
    }

    fun getImage(): String {
        return prefTasks.getString(IMAGE_KEY, "").toString()
    }

    fun imageSave(image: String) {
        prefTasks.edit().putString(IMAGE_KEY, image).apply()
    }

    companion object {
        const val SHARED_NAME = "task_app"
        const val SEEN_KEY = "isSeen"
        const val NAME_KEY = "nameKey"
        const val IMAGE_KEY = "imageKey"
    }
}