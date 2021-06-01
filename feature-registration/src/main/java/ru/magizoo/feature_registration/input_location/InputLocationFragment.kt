package ru.magizoo.feature_registration.input_location

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_registration.R
import ru.magizoo.feature_registration.databinding.FragmentInputLocationBinding

@AndroidEntryPoint
class InputLocationFragment: BaseFragment(R.layout.fragment_input_location) {

    private val viewModel: InputLocationViewModel by viewModels()
    private val binding by viewBinding<FragmentInputLocationBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = LocationAdapter(object : LocationAdapter.Listener {
            override fun onItemClick(position: Int) {
//                viewModel.selectItem(position)
            }
        })
        binding.inputLocationList.addItemDecoration(DividerItemDecoration(requireActivity(), LinearLayoutManager.VERTICAL))
        binding.inputLocationList.adapter = adapter

        binding.inputLocationRefreshLayout.setOnRefreshListener {
            binding.inputLocationSearchText.text.clear()
            viewModel.loadCities()
        }

        binding.inputLocationSearchText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.loadCities(text.toString())
            }

            override fun afterTextChanged(p0: Editable?) = Unit
        })

        viewModel.loading.observe(viewLifecycleOwner, {
            binding.inputLocationRefreshLayout.isRefreshing = it
        })

        viewModel.cities.observe(viewLifecycleOwner, {
            adapter.setItems(it)
        })

    }

    override fun onStart() {
        super.onStart()
        viewModel.loadCities()
    }
}