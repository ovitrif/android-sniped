package com.sniped.ui.main.detail

import android.app.Activity
import android.content.Intent
import com.sniped.ui.navigator.Navigator
import javax.inject.Inject

class DetailNavigator @Inject constructor(private val activity: Activity) : Navigator {

    override fun navigate() {
        val intent = Intent(activity, DetailActivity::class.java)

        activity.startActivity(intent)
    }
}
