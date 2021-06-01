package ru.magizoo.feature_registration.input_user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_registration.R
import ru.magizoo.feature_registration.databinding.FragmentInputUserBinding

@AndroidEntryPoint
class InputUserFragment: BaseFragment(R.layout.fragment_input_user) {

    private val viewModel: InputUserViewModel by viewModels()
    private val binding by viewBinding<FragmentInputUserBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.firstNameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.changedFirstName(text.toString())
            }

            override fun afterTextChanged(p0: Editable?) = Unit
        })

        binding.nameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.changedName(text.toString())
            }

            override fun afterTextChanged(p0: Editable?) = Unit
        })

        binding.secondNameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.changedSecondName(text.toString())
            }

            override fun afterTextChanged(p0: Editable?) = Unit
        })

        binding.continueButton.setOnClickListener {
//            viewModel.sendUserData()
            viewModel.navigateToInputLocation()
        }

        viewModel.isValidInputData.observe(viewLifecycleOwner, {
            if (it) {
                binding.continueButton.background = ContextCompat.getDrawable(requireActivity(), R.drawable.first_button_background)
            } else {
                binding.continueButton.background = ContextCompat.getDrawable(requireActivity(), R.drawable.disabled_button_background)
            }
        })
    }
}