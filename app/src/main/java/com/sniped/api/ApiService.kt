package com.sniped.api

import com.sniped.domain.entities.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API calls interface implemented by Retrofit2.
 * Use specific RxJava return types like: Single, Completable, Observable.
 */
interface ApiService {

    @GET("users/{userName}")
    fun getUser(@Path("userName") userName: String): Single<User>
}
