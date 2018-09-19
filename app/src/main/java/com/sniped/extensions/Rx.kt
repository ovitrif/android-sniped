package com.sniped.extensions

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 * Subscribes with empty consumers.
 */
fun <T : Any> Single<T>.subscribeEmpty(): Disposable = subscribe({}, {})

/**
 * Subscribes with empty consumers.
 */
fun <T : Any> Completable.subscribeEmpty(): Disposable = subscribe({}, {})

/**
 * Subscribes with empty consumers.
 */
fun <T : Any> Observable<T>.subscribeEmpty(): Disposable = subscribe({}, {})
