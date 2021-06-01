package ru.magizoo.feature_basket.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.feature_basket.R

@AndroidEntryPoint
class BasketFragment: BaseFragment(R.layout.fragment_basket) {
    override val isVisibleBottomNavigationBar = true

    private val viewModel: BasketViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}