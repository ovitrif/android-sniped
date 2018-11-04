package com.sniped.ui.main.detail.validator

import com.sniped.ui.validator.Validator

class MinLengthValidator(private val value: String) : Validator {

    override fun isValid() = value.count() > 3
}
