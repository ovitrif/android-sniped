package com.sniped.ui

/**
 * Base presenter interface.
 */
interface Presentable {

    fun onAttach() = Unit
    fun onDetach() = Unit

    companion object {
        val NULL = object : Presentable {}
    }
}
