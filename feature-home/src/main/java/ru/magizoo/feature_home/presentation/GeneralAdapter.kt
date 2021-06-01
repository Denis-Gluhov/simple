package ru.magizoo.feature_home.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.magizoo.feature_home.R

class GeneralAdapter(
    private val listener: Listener
): RecyclerView.Adapter<GeneralAdapter.GeneralViewHolder>() {

    interface Listener {
        fun onItemClick(item: ItemCategory)
    }

    private val data = ArrayList<ItemCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_general, parent, false)
        return GeneralViewHolder(view)
    }

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.view.findViewById<LinearLayout>(R.id.item_category_general_container)
            .setOnClickListener { listener.onItemClick(item) }
    }

    override fun getItemCount(): Int = data.size

    fun setData(data: List<ItemCategory>) {
        this.data.clear()
        this.data.addAll(data)
        this.notifyDataSetChanged()
    }

    inner class GeneralViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ItemCategory) {
            view.findViewById<ImageView>(R.id.item_category_general_picture)
                .setImageDrawable(ContextCompat.getDrawable(view.context, item.picture))
            view.findViewById<TextView>(R.id.item_category_general_name).text = item.name
            view.findViewById<TextView>(R.id.item_category_general_count).text = item.count
        }
    }

}