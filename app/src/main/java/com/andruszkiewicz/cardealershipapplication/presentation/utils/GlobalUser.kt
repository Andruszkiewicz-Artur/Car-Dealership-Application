package com.andruszkiewicz.cardealershipapplication.presentation.utils

import android.util.Log
import com.andruszkiewicz.cardealershipapplication.domain.repository.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object GlobalUser {

    private val TAG = GlobalUser::class.java.simpleName

    private val _user = MutableStateFlow<UserModel?>(null)
    val user = _user.asStateFlow()

    fun updateUser(user: UserModel?) {
        _user.update { user }
    }

}