package com.sniped.ui.main.detail

import androidx.annotation.StringRes

interface IDetail {

    interface View {
        val userName: String
        var dataText: String
        fun setInputError(@StringRes errorMessage: Int)
        fun clearInputError()
    }
}
