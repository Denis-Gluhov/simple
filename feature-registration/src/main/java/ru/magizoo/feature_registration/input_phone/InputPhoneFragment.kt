package ru.magizoo.feature_registration.input_phone

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.redmadrobot.inputmask.MaskedTextChangedListener
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_registration.R
import ru.magizoo.feature_registration.databinding.FragmentInputPhoneBinding

@AndroidEntryPoint
class InputPhoneFragment: BaseFragment(R.layout.fragment_input_phone) {
    override val isVisibleBottomNavigationBar = true

    private val viewModel: InputPhoneViewModel by viewModels()
    private val binding by viewBinding<FragmentInputPhoneBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.continueInputPhoneButton.setOnClickListener { viewModel.registration() }
        binding.privacyPolicyInputPhoneText.setOnClickListener { viewModel.navigateToPrivacyPolicy() }

        viewModel.isValidPhoneNumber.observe(viewLifecycleOwner, {
            if (it)
                binding.continueInputPhoneButton.background = ContextCompat.getDrawable(requireActivity(), R.drawable.first_button_background)
            else
                binding.continueInputPhoneButton.background = ContextCompat.getDrawable(requireActivity(), R.drawable.disabled_button_background)
        })

        val listener = MaskedTextChangedListener("+7([000]) [000] - [00] - [00]", binding.numberInputPhoneText)
        binding.numberInputPhoneText.addTextChangedListener(listener)
        binding.numberInputPhoneText.onFocusChangeListener = listener
        binding.numberInputPhoneText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.validatePhoneNumber(sequence.toString())
            }
        })
    }

}