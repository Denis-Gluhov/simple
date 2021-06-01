package ru.magizoo.magizoo.presentation.product_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.magizoo.magizoo.R

class VariantsAdapter(
    private val items: MutableList<ItemVariant>
): RecyclerView.Adapter<VariantsAdapter.VariantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_variant, parent, false)
        return VariantViewHolder(view)
    }

    override fun onBindViewHolder(holder: VariantViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class VariantViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ItemVariant) {
            view.findViewById<TextView>(R.id.item_product_variant_label).text = item.smallName
            view.findViewById<TextView>(R.id.item_product_variant_price).text = "${item.price} ₽"
        }
    }
}