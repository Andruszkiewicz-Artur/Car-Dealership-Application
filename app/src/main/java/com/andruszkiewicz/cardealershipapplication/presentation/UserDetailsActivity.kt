package com.andruszkiewicz.cardealershipapplication.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.andruszkiewicz.cardealershipapplication.R
import com.andruszkiewicz.cardealershipapplication.databinding.ActivityLoginBinding
import com.andruszkiewicz.cardealershipapplication.databinding.ActivityUserDetailsBinding
import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.presentation.utils.GlobalUser
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserDetailsActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityUserDetailsBinding
    private val binding get() = _binding

    @Inject
    lateinit var repository: CarDealershipRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initListener()
    }

    private fun initListener() {
        with(binding) {
            backBnt.setOnClickListener {
                onBackPressed()
            }
            logOutBnt.setOnClickListener {
                GlobalUser.updateUser(null)
                onBackPressed()
                val intent = Intent(this@UserDetailsActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initView() {
        with(binding) {
            GlobalUser.user.value?.let { user ->
                detailsInfoTv.text = """
                    Login: ${user.login}
                    Email: ${user.email}
                    Phone number: ${user.phone}
                    Name: ${user.first_name}
                    Surname: ${user.last_name}
                """.trimIndent()
            }
        }
    }
}