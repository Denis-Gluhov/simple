package ru.magizoo.feature_catalog.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.magizoo.feature_catalog.R

class CatalogAdapter(
//    private val listener: Listener
): RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

//    interface Listener {
//        fun onClickItem(item: ItemCategory)
//    }

//    private val items = ArrayList<ItemCategory>()
//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category_catalog, parent, false)
        return CatalogViewHolder(view)
    }
//
    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
//        val item = items[position]
//        holder.bind(item)
//        holder.view.findViewById<LinearLayout>(R.id.item_category_catalog_container)
//            .setOnClickListener { listener.onClickItem(item) }
    }
//
    override fun getItemCount(): Int = 0
//
//    fun setItems(items: List<ItemCategory>) {
//        this.items.clear()
//        this.items.addAll(items)
//        this.notifyDataSetChanged()
//    }
//
    inner class CatalogViewHolder(val view: View): RecyclerView.ViewHolder(view) {
//        fun bind(item: ItemCategory) {
//            view.findViewById<ImageView>(R.id.item_category_catalog_picture)
//                .setImageDrawable(ContextCompat.getDrawable(view.context, item.picture))
//            view.findViewById<TextView>(R.id.item_category_catalog_name).text = item.name
//        }
    }
}