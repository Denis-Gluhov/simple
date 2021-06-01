package ru.magizoo.feature_home.presentation

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.magizoo.feature_home.R

class ActionsAdapter(
    private val listener: Listener
): RecyclerView.Adapter<ActionsAdapter.ActionViewHolder>() {

    interface Listener {
        fun onClickItem(position: Int)
    }

    private val items = ArrayList<ItemAction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_action, parent, false)
        return ActionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<ItemAction>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    inner class ActionViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(item: ItemAction) {
            view.findViewById<TextView>(R.id.item_action_title).text = item.title
            val picture = view.findViewById<ImageView>(R.id.item_action_picture)
            val rating = view.findViewById<RatingBar>(R.id.item_action_rating)
            val date = view.findViewById<TextView>(R.id.item_action_date)
            val name = view.findViewById<TextView>(R.id.item_action_name)
            val oldPrice = view.findViewById<TextView>(R.id.item_action_old_price)
            val price = view.findViewById<TextView>(R.id.item_action_price)
            val pay = view.findViewById<Button>(R.id.item_action_pay)

            Glide.with(view.context)
                .load("https://spb.magizoo.ru/${item.picture}")
                .into(picture)
            rating.rating = item.rating
            date.text = item.date
            name.text = item.name
            oldPrice.text = "${item.oldPrice} ₽"
            oldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            price.text = "${item.price} ₽"
        }

    }

}