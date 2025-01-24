package com.andruszkiewicz.cardealershipapplication.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.andruszkiewicz.cardealershipapplication.R
import com.andruszkiewicz.cardealershipapplication.databinding.ActivityCarDetailsBinding
import com.andruszkiewicz.cardealershipapplication.databinding.ActivityLoginBinding
import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.domain.repository.UserModel
import com.andruszkiewicz.cardealershipapplication.presentation.utils.GlobalUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityLoginBinding
    private val binding get() = _binding

    @Inject
    lateinit var repository: CarDealershipRepository

    private var users = emptyList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        takeData()
        initListener()
    }

    private fun takeData() {
        lifecycleScope.launch(Dispatchers.IO) {
            users = repository.getUsers()
            Timber.d("takeData: users: %s", users)
        }
    }

    private fun initListener() {
        with(binding) {
            backBnt.setOnClickListener {
                onBackPressed()
            }
            logInBnt.setOnClickListener {
                validData()
            }
        }
    }

    private var email = ""
    private var password = ""

    private fun validData() {
        with(binding) {
            email = mailEt.text.toString().trim()
            password = passwordEt.text.toString().trim()
        }

        if (email.isBlank()) {
            binding.mailEt.error = "Entered mail!"
            binding.mailEt.requestFocus()
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.mailEt.error = "Invalid mail!"
            binding.mailEt.requestFocus()
        } else if (password.isBlank()) {
            binding.passwordEt.error = "Entered password!"
            binding.passwordEt.requestFocus()
        } else {
            logIn()
        }
    }

    private fun logIn() {
        val user = users.find { it.email == email }
        if (user == null) {
            binding.mailEt.error = "User with that email not exist!"
            binding.mailEt.requestFocus()
        } else if (user.password_hash != password) {
            binding.passwordEt.error = "Wrong password!"
            binding.passwordEt.requestFocus()
        } else {
            GlobalUser.updateUser(user)
            onBackPressed()
        }
    }
}