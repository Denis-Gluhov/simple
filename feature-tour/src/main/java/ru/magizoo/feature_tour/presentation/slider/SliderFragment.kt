package ru.magizoo.feature_tour.presentation.slider

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_tour.R
import ru.magizoo.feature_tour.databinding.FragmentSliderBinding

@AndroidEntryPoint
class SliderFragment: BaseFragment(R.layout.fragment_slider) {

    private val viewModel: SliderViewModel by viewModels()
    private val binding: FragmentSliderBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initSlider()
        initClickListeners()
        initObservers()
    }

    private fun initClickListeners() {
        binding.sliderContinue.setOnClickListener {
            viewModel.navigateToRegistration()
        }
    }

    private fun initSlider() {
        val adapter = SlideAdapter(viewModel.slides, object : SlideAdapter.ClickListener {
            override fun onClickAction(item: Slide) {
                viewModel.clickAction(item)
            }
        })
        binding.sliderPager.adapter = adapter
        TabLayoutMediator(binding.sliderIndicator, binding.sliderPager) { _, _ -> }.attach()
        binding.sliderPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.currentPosition = position
            }
        })

    }

    private fun initObservers() {
        viewModel.slidePosition.observe(viewLifecycleOwner, {
            binding.sliderPager.currentItem = it
        })
    }


}