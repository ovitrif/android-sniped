package com.sniped.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Focuses the view and shows soft input keyboard.
 */
fun View.showKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    this.requestFocus()
    inputManager.showSoftInput(this, 0)
}

/**
 * Hides the soft input keyboard.
 */
fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(this.windowToken, 0)
}
