package ru.magizoo.magizoo.presentation.product_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.magizoo.magizoo.R

class ProductListAdapter(): RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private val items = ArrayList<ItemProduct>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_list, parent, false)
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<ItemProduct>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    inner class ProductListViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        @SuppressLint("CheckResult")
        fun bind(item: ItemProduct) {
            val imageView = view.findViewById<ImageView>(R.id.item_product_list_picture)
            Glide.with(view.context)
                .load("https://spb.magizoo.ru/${item.picture}")
                .into(imageView)
            view.findViewById<RatingBar>(R.id.item_product_list_rating).rating = item.rating
            view.findViewById<TextView>(R.id.item_product_list_name).text = item.name

            val varAdapter = VariantsAdapter(item.variants as MutableList<ItemVariant>)
            val rv = view.findViewById<RecyclerView>(R.id.item_product_list_recycler)
            rv.addItemDecoration(DividerItemDecoration(view.context,
                LinearLayoutManager.VERTICAL))
            rv.adapter = varAdapter
            varAdapter.notifyDataSetChanged()
        }
    }
}