package ru.magizoo.feature_profile.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.feature_profile.R

@AndroidEntryPoint
class ProfileFragment: BaseFragment(R.layout.fragment_profile) {
    override val isVisibleBottomNavigationBar = true

    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}