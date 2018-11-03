package com.sniped.core

import android.os.Handler
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Exposes schedulers for multithreading.
 */
class Threads constructor(private val mainThread: Handler) {

    fun main() = mainThread

    fun io() = Schedulers.io()

    fun ui() = AndroidSchedulers.mainThread() as Scheduler

    fun computation() = Schedulers.computation()
}
