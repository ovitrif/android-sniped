package com.sniped.ui.main.detail

import com.sniped.R
import com.sniped.core.Threads
import com.sniped.extensions.subscribeEmpty
import com.sniped.ui.main.MainNavigator
import com.sniped.ui.main.detail.acts.GetUserByNameAct
import com.sniped.ui.main.detail.validator.MinLengthValidator
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailPresenter @Inject constructor(
        private val view: IDetail.View,
        private val getUserByNameAct: GetUserByNameAct,
        private val threads: Threads,
        private val mainNavigator: MainNavigator) : IDetail.Presenter {

    private val jobsBag = CompositeDisposable()

    override fun onShow() {
    }

    override fun onGetClick() {
        if (MinLengthValidator(view.userName).isValid()) {
            view.clearInputError()

            val getUserByNameJob = getUserByNameAct.execute(view.userName)
                    .subscribeOn(threads.io())
                    .observeOn(threads.ui())
                    .doOnSuccess {
                        view.dataText = it.toString()
                    }
                    .subscribeEmpty()
            jobsBag.add(getUserByNameJob)
        } else {
            view.setInputError(R.string.validation_min_length_3)
        }
    }

    override fun onBackPressed() = mainNavigator.navigate()

    override fun onHide() {
        jobsBag.clear()
    }
}
