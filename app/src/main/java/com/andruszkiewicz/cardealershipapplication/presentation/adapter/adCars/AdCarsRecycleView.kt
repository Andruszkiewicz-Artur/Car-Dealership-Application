package com.andruszkiewicz.cardealershipapplication.presentation.adapter.adCars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.andruszkiewicz.cardealershipapplication.R
import com.andruszkiewicz.cardealershipapplication.databinding.CarAdHomeViewBinding
import com.andruszkiewicz.cardealershipapplication.domain.mode.CarModel
import com.bumptech.glide.Glide

class AdCarsRecycleView(
    private var onAdClick: (CarModel) -> Unit
): RecyclerView.Adapter<AdCarsRecycleView.AdCarsViewHolder>() {

    var cars: List<CarModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class AdCarsViewHolder(val binding: CarAdHomeViewBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdCarsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CarAdHomeViewBinding.inflate(inflater)
        return AdCarsViewHolder(binding)
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: AdCarsViewHolder, position: Int) {
        val car = cars[position]
        val carImage = car.imagesUrl.firstOrNull()

        with(holder.binding) {
            if (carImage != null)
                Glide.with(holder.itemView)
                    .load(carImage)
                    .placeholder(R.drawable.ic_image_gray)
                    .error(R.drawable.ic_image_gray)
                    .into(adIv)

            brandTv.text = car.brand
            modelTv.text = car.model
            priceTv.text = "${car.price} zł"

            adMcv.setOnClickListener { onAdClick(car) }
        }
    }

}