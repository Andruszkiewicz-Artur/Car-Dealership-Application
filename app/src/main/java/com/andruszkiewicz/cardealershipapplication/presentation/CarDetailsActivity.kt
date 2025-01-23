package com.andruszkiewicz.cardealershipapplication.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andruszkiewicz.cardealershipapplication.databinding.ActivityCarDetailsBinding
import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.presentation.adapter.carImages.CarImagesAdapter
import com.andruszkiewicz.cardealershipapplication.presentation.utils.PresentationUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class CarDetailsActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityCarDetailsBinding
    private val binding get() = _binding

    @Inject
    lateinit var repository: CarDealershipRepository

    private val imagesAdapter: CarImagesAdapter = CarImagesAdapter()

    private var carId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityCarDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carId = intent.extras?.getInt(PresentationUtils.CAR_ID)

        setImagesAdapter()
        initListener()
        initView()
    }

    private fun initView() {
        lifecycleScope.launch(Dispatchers.IO) {
            if (carId != null) {
                repository.getCar(carId!!)?.let { car ->
                    withContext(Dispatchers.Main) {
                        with(binding) {
                            imagesAdapter.imagesUrl = car.imagesUrl
                            detailsTv.text = """
                                Marka: ${car.brand}
                                Cena: ${car.price}
                                Typ nadwozia: ${car.body_type}
                                Moc: ${car.power} KM
                                Skrzynia biegów: ${car.transmission}
                                Kolor: ${car.color}
                                Rok produkcji: ${car.production_year}
                                
                                
                                Opis: 
                                ${car.description}
                            """.trimIndent()
                        }
                    }
                }
            }
        }
    }

    private fun setImagesAdapter() {
        binding.imagesRv.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.HORIZONTAL,
            false
        )

        binding.imagesRv.adapter = imagesAdapter
    }

    private fun initListener() {
        with(binding) {
            backBnt.setOnClickListener {
                onBackPressed()
            }
        }
    }
}