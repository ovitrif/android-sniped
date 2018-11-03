package com.sniped.ui

/**
 * Base presenter interface.
 */
interface Presentable {

    fun onShow() = Unit
    fun onHide() = Unit

    companion object {
        val NULL = object : Presentable {}
    }
}
