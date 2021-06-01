package ru.magizoo.feature_tour.presentation.slider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.magizoo.feature_tour.databinding.ItemSlideBinding

class SlideAdapter(
    private val items: List<Slide>,
    private val listener: ClickListener
) : RecyclerView.Adapter<SlideAdapter.SlideViewHolder>() {

    interface ClickListener {
        fun onClickAction(item: Slide)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        return SlideViewHolder(ItemSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class SlideViewHolder(private val binding: ItemSlideBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Slide) = with(binding) {
            binding.slidePicture.setImageResource(item.picture)
            binding.slideTitle.setText(item.title)
            binding.slideBody.setText(item.body)
            binding.slidePrimaryAction.setText(item.action)
            binding.slidePrimaryAction.setOnClickListener { listener.onClickAction(item) }
        }
    }

}