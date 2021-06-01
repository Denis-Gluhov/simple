package ru.magizoo.feature_registration.input_location

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ru.magizoo.feature_registration.R

class LocationAdapter(
    private val listener: Listener
): RecyclerView.Adapter<LocationAdapter.CityViewHolder>() {

    interface Listener {
        fun onItemClick(position: Int)
    }

    private val items = ArrayList<City>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(items[position])
        holder.view.findViewById<ConstraintLayout>(R.id.item_city_container).setOnClickListener {
            items.forEach { it.isSelected = false }
            items[position].isSelected = true
            notifyDataSetChanged()
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<City>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setItem(item: City, position: Int) {
        items[position] = item
        notifyItemChanged(position, item)
    }

    inner class CityViewHolder(
        val view: View
    ): RecyclerView.ViewHolder(view) {

        fun bind(item: City) {
            view.findViewById<TextView>(R.id.item_city_name).text = item.name
            view.findViewById<RadioButton>(R.id.item_city_select).isChecked = item.isSelected
        }

    }

}