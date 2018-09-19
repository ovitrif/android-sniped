package com.sniped.ui.main

import com.sniped.ui.main.detail.DetailNavigator
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val view: IMain.View,
        private val detailNavigator: DetailNavigator) : IMain.Presenter {

    override fun onShow() {
    }

    override fun onDetailNavBtnClick() = detailNavigator.navigate()

    override fun onHide() {
    }
}
