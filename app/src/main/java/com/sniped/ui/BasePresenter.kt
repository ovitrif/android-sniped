package com.sniped.ui

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : Presentable {

    internal val disposeBag = CompositeDisposable()

    override fun onAttach() {
    }

    override fun onDetach() {
        disposeBag.clear()
    }
}
