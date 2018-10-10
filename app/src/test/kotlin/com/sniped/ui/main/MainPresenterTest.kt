package com.sniped.ui.main

import com.nhaarman.mockito_kotlin.verify
import com.sniped.test.MockitoTest
import com.sniped.ui.main.detail.DetailNavigator
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class MainPresenterTest : MockitoTest() {

    @Mock private lateinit var view: IMain.View
    @Mock private lateinit var detailNavigator: DetailNavigator

    private lateinit var presenter: MainPresenter

    @Before
    fun setUp() {
        presenter = MainPresenter(
                view,
                detailNavigator)
    }

    @Test
    fun whenClickingDetailNavButton_shouldNavigateToDetailView() {
        presenter.onDetailNavBtnClick()

        verify(detailNavigator).navigate()
    }
}
