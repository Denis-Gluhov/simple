package ru.magizoo.feature_home.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.magizoo.feature_home.R

class BannersAdapter(
    private val listener: Listener
): RecyclerView.Adapter<BannersAdapter.BannerViewHolder>() {

    interface Listener {
        fun onItemClick(position: Int)
    }

    private val items: MutableList<ItemBanner> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<ItemBanner>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    inner class BannerViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: ItemBanner) {
            val imageView = view.findViewById<ImageView>(R.id.item_banner_picture)
            Glide.with(view.context)
                .load("https://spb.magizoo.ru/${item.picture}")
                .into(imageView)
        }

    }

}