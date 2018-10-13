package com.sniped.ui

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : Presentable {

    protected val jobsBag = CompositeDisposable()

    override fun onShow() {
    }

    override fun onHide() {
        jobsBag.clear()
    }
}
