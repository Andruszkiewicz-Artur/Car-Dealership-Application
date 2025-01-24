package com.andruszkiewicz.cardealershipapplication.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.andruszkiewicz.cardealershipapplication.databinding.ActivityRegisterBinding
import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.domain.mode.UserModel
import com.andruszkiewicz.cardealershipapplication.presentation.utils.GlobalUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityRegisterBinding
    private val binding get() = _binding

    @Inject
    lateinit var repository: CarDealershipRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        with(binding) {
            backBnt.setOnClickListener {
                onBackPressed()
            }
            registerBnt.setOnClickListener {
                validData()
            }
        }
    }

    private var login = ""
    private var email = ""
    private var phoneNumber = ""
    private var name = ""
    private var surName = ""
    private var password = ""
    private var rePassword = ""

    private fun validData() {
        with(binding) {
            login = loginEt.text.toString().trim()
            email = mailEt.text.toString().trim()
            phoneNumber = phoneEt.text.toString().trim()
            name = nameEt.text.toString().trim()
            surName = surNameEt.text.toString().trim()
            password = passwordEt.text.toString().trim()
            rePassword = rePasswordEt.text.toString().trim()
        }

        if (email.isBlank()) {
            binding.mailEt.error = "Entered mail!"
            binding.mailEt.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.mailEt.error = "Invalid mail!"
            binding.mailEt.requestFocus()
        } else if (login.isBlank()) {
            binding.loginEt.error = "Entered login!"
            binding.loginEt.requestFocus()
        } else if (name.isBlank()) {
            binding.nameEt.error = "Entered name!"
            binding.nameEt.requestFocus()
        } else if (surName.isBlank()) {
            binding.surNameEt.error = "Entered surname!"
            binding.surNameEt.requestFocus()
        } else if (password.isBlank()) {
            binding.passwordEt.error = "Entered password!"
            binding.passwordEt.requestFocus()
        } else if (rePassword.isBlank()) {
            binding.rePasswordEt.error = "Entered re-password!"
            binding.rePasswordEt.requestFocus()
        } else if (password != rePassword) {
            binding.passwordEt.error = "Passwords are not the same!"
            binding.passwordEt.requestFocus()
        } else {
            register()
        }
    }

    private fun register() {
        lifecycleScope.launch(Dispatchers.IO) {
            val userModel = UserModel(
                login = login,
                password_hash = password,
                email = email,
                phone = phoneNumber,
                first_name = name,
                last_name = surName
            )

            Timber.d("register: userModel: %s", userModel)

            repository.createUser(userModel).let { isUser ->
                Timber.d("register: isUser: %s", isUser)
                if (isUser) {
                    GlobalUser.updateUser(userModel)
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@RegisterActivity, "Problem with log in", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}