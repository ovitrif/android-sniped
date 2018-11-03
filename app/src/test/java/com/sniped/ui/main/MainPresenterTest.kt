package com.sniped.ui.main

import com.nhaarman.mockitokotlin2.verify
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
                detailNavigator)
    }

    @Test
    fun whenClickingDetailButton_shouldNavigateToDetailView() {
        presenter.onDetailButtonClick()

        verify(detailNavigator).navigate()
    }
}
