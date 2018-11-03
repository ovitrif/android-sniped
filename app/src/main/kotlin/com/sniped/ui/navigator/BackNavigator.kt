package com.sniped.ui.navigator

import android.app.Activity
import javax.inject.Inject

class BackNavigator @Inject constructor(private val activity: Activity) : Navigator {

    override fun navigate() {
        activity.finish()
    }
}
