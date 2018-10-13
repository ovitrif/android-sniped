package com.sniped.ui.main

import com.sniped.ui.BasePresenter
import com.sniped.ui.main.detail.DetailNavigator
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val detailNavigator: DetailNavigator) : BasePresenter(), IMain.Presenter {

    override fun onDetailButtonClick() = detailNavigator.navigate()
}
