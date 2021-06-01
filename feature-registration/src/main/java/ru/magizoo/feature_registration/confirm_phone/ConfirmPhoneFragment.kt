package ru.magizoo.feature_registration.confirm_phone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.poovam.pinedittextfield.PinField
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_registration.R
import ru.magizoo.feature_registration.databinding.FragmentConfirmPhoneBinding

@AndroidEntryPoint
class ConfirmPhoneFragment : BaseFragment(R.layout.fragment_confirm_phone) {

    private val viewModel: ConfirmPhoneViewModel by viewModels()
    private val binding by viewBinding<FragmentConfirmPhoneBinding>()
    private val arguments by navArgs<ConfirmPhoneFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.confirmPhoneToolbar.setNavigationOnClickListener { viewModel.navigateToBack() }

        binding.pinConfirmPhoneText.onTextCompleteListener = object : PinField.OnTextCompleteListener{
            override fun onTextComplete(enteredText: String): Boolean {
                arguments.phone?.let { viewModel.confirm(it, enteredText) }
                return true
            }
        }

        binding.repeatConfirmPhoneButton.setOnClickListener {
            /***/
        }

        viewModel.visibleErrorPinCode.observe(viewLifecycleOwner, {
            binding.errorPinConfirmPhoneText.visibility = it
        })
    }

}