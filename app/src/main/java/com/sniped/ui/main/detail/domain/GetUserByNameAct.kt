package com.sniped.ui.main.detail.domain

import com.sniped.api.ApiService
import javax.inject.Inject

class GetUserByNameAct @Inject constructor(
        private val apiService: ApiService) {

    fun execute(userName: String) = apiService.getUser(userName)
}
