package ru.magizoo.magizoo.presentation.subcategory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.magizoo.magizoo.R

class SubCategoryAdapter(
    private val listener: Listener
): RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    interface Listener {
        fun onClickItem(item: ItemSubCategory)
    }

    private val items = ArrayList<ItemSubCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory, parent, false)
        return SubCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.view.findViewById<LinearLayout>(R.id.item_subcategory_container)
            .setOnClickListener { listener.onClickItem(item) }
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<ItemSubCategory>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    inner class SubCategoryViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ItemSubCategory) {
            view.findViewById<TextView>(R.id.item_subcategory_name).text = item.name
        }
    }
}