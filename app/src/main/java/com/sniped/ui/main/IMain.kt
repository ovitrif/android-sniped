package com.sniped.ui.main

import android.support.annotation.ColorInt
import com.sniped.ui.Presentable

interface IMain {

    interface View {
        fun setDetailBtnBgColor(@ColorInt color: Int)
    }

    interface Presenter : Presentable {
        fun onDetailNavBtnClick()
    }
}
