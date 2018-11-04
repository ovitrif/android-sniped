package com.sniped.ui

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : Presentable {

    internal val disposeBag = CompositeDisposable()

    override fun onShow() {
    }

    override fun onHide() {
        disposeBag.clear()
    }
}
