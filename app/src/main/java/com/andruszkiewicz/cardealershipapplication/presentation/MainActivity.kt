package com.andruszkiewicz.cardealershipapplication.presentation

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.andruszkiewicz.cardealershipapplication.databinding.ActivityMainBinding
import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.presentation.adapter.adCars.AdCarsRecycleView
import com.andruszkiewicz.cardealershipapplication.presentation.utils.PresentationUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    @Inject
    lateinit var repository: CarDealershipRepository

    private lateinit var adCarsAdapter: AdCarsRecycleView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        takeAds()
    }

    private fun initView() {
        with(binding) {
            adCarsAdapter = AdCarsRecycleView(
                onAdClick = { car ->
                    val intent = Intent(this@MainActivity, CarDetailsActivity::class.java)
                    intent.putExtra(PresentationUtils.CAR_ID, car.id)
                    startActivity(intent)
                }
            )

            val decoration = object : ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    with(outRect) {
                        top = 16
                        bottom = 16
                    }
                }
            }

            adRv.addItemDecoration(decoration)
            adRv.layoutManager = LinearLayoutManager(this@MainActivity)
            adRv.adapter = adCarsAdapter
        }
    }

    private fun takeAds() {
        lifecycleScope.launch(Dispatchers.IO) {
            repository.getCars().also { cars ->
                withContext(Dispatchers.Main) {
                    adCarsAdapter.cars = cars
                }
            }
        }
    }
}