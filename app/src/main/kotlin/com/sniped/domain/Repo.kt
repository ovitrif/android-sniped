package com.sniped.domain

/**
 * Base repository interface.
 */
interface Repo<T> {

    val isSet: Boolean

    fun get(): T

    fun set(request: T)

    fun clear()
}
