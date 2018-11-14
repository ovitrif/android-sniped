package com.sniped.ui

import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer
import io.reactivex.rxkotlin.plusAssign
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Before
import org.junit.Test

class BasePresenterTest {

    private lateinit var presenter: BasePresenter

    @Before
    fun setUp() {
        presenter = object : BasePresenter() {}
    }

    @Test
    fun disposeBag_isAnEmptyDisposableContainer() {
        assertThat(presenter.disposeBag)
                .isInstanceOf(DisposableContainer::class.java)
                .isInstanceOf(Disposable::class.java)
        assertThat(presenter.disposeBag.size()).isZero()
    }

    @Test
    fun onShow_never_throws() {
        presenter.onAttach()
    }

    @Test
    fun onHide_always_clearsDisposeBag() {
        presenter.disposeBag += Single.just(true).subscribe()
        assertThat(presenter.disposeBag.size()).isOne()

        presenter.onDetach()

        assertThat(presenter.disposeBag.size()).isZero()
    }
}
