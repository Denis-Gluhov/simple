package ru.magizoo.feature_tour.presentation.tour

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_tour.R
import ru.magizoo.feature_tour.databinding.FragmentTourBinding

@AndroidEntryPoint
class TourFragment : BaseFragment(R.layout.fragment_tour) {

    private val viewModel: TourViewModel by viewModels()
    private val binding: FragmentTourBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tourContinueButton.setOnClickListener {
            viewModel.navigateToSlider()
        }
    }

}