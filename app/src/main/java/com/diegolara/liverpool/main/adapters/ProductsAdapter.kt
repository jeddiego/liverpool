package com.diegolara.liverpool.main.adapters

import com.diegolara.liverpool.domain.ProductsModel
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diegolara.liverpool.R
import com.diegolara.liverpool.databinding.ItemProductsBinding
import com.google.android.material.chip.Chip

class ProductsAdapter(
    context: Context,
    private val onClickCallback: ((item: ProductsModel) -> Unit)?
):
    ListAdapter<ProductsModel, ProductsAdapter.ItemViewholder>(DiffCallback()) {
    private var r: Resources = context.resources

    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemProductsBinding.bind(itemView)

        fun bind(item: ProductsModel, position: Int) = with(binding) {
            tvItemProductsName.text = item.name
            tvItemProductsPriceWithDiscount.text = item.priceWithDiscont.toString()
            tvItemProductsPriceWithoutDiscount.text = item.priceWithoutDiscount.toString()
            Glide
                .with(ivItemProductsImage.context)
                .load(item.image)
                .into(ivItemProductsImage)

            item.variantsColor.forEach {
                val chip = LayoutInflater.from(tvItemProductsName.context)
                    .inflate(R.layout.item_products_colors, null, false) as TextView

                if(it.colorHex.isNotEmpty()) {
                    chip.setBackgroundColor(Color.parseColor(it.colorHex))
                    llItemProductsColors.addView(chip)
                }
            }
        }

        init {
            itemView.setOnClickListener { onClickCallback?.invoke(getItem(adapterPosition)) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder =
        ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_products, parent, false)
        )

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }
}

class DiffCallback:DiffUtil.ItemCallback<ProductsModel>() {
    override fun areItemsTheSame(oldItem: ProductsModel, newItem: ProductsModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductsModel, newItem: ProductsModel): Boolean {
        return oldItem == newItem
    }
}