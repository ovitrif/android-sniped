package com.sniped.ui.main

import android.app.Activity
import android.content.Intent
import com.sniped.ui.navigator.Navigator
import javax.inject.Inject

class MainNavigator @Inject constructor(private val activity: Activity) : Navigator {

    override fun navigate() {
        val intent = Intent(activity, MainActivity::class.java)

        activity.startActivity(intent)
    }
}
