package com.sniped.ui.main

import com.sniped.ui.Presentable

interface IMain {

    interface View

    interface Presenter : Presentable {
        fun onDetailButtonClick()
    }
}
