package ru.magizoo.feature_policy.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_policy.R
import ru.magizoo.feature_policy.databinding.FragmentPolicyBinding

@AndroidEntryPoint
class PolicyFragment: BaseFragment(R.layout.fragment_policy) {

    private val viewModel: PolicyViewModel by viewModels()
    private val binding: FragmentPolicyBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.privacyPolicyToolbar.setNavigationOnClickListener {
            viewModel.navigateToBack()
        }
    }
}