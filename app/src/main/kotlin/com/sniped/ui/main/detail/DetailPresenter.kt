package com.sniped.ui.main.detail

import com.sniped.R
import com.sniped.core.Threads
import com.sniped.extensions.subscribeEmpty
import com.sniped.ui.BasePresenter
import com.sniped.ui.main.detail.domain.GetUserByNameAct
import com.sniped.ui.main.detail.validator.MinLengthValidator
import com.sniped.ui.navigator.BackNavigator
import javax.inject.Inject

class DetailPresenter @Inject constructor(
        private val view: IDetail.View,
        private val getUserByNameAct: GetUserByNameAct,
        private val threads: Threads,
        private val backNavigator: BackNavigator) : BasePresenter(), IDetail.Presenter {

    override fun onGetButtonClick() {
        if (MinLengthValidator(view.userName).isValid()) {
            view.clearInputError()

            val asyncJob = getUserByNameAct.execute(view.userName)
                    .subscribeOn(threads.io())
                    .observeOn(threads.ui())
                    .doOnSuccess {
                        view.dataText = it.toString()
                    }
                    .subscribeEmpty()
            disposeBag.add(asyncJob)
        } else {
            view.setInputError(R.string.validation_min_length_3)
        }
    }

    override fun onBackPressed() = backNavigator.navigate()
}
