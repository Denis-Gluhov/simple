package ru.magizoo.feature_home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.feature_home.R
import ru.magizoo.feature_home.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment: BaseFragment(R.layout.fragment_home) {
    override val isVisibleBottomNavigationBar = true

    private val viewModel: HomeViewModel by viewModels()
    private val binding by viewBinding<FragmentHomeBinding>()

//    private lateinit var recyclerList: RecyclerView
    private lateinit var categoriesAdapter: GeneralAdapter
    private lateinit var category: ItemCategory
//    private lateinit var bannersSlider: ViewPager2
//    private lateinit var bannersSliderIndicator: TabLayout
    private lateinit var bannersAdapter: BannersAdapter

//    private lateinit var recyclerActionsOfWeek: RecyclerView
    private lateinit var actionsOfWeekAdapter: ActionsAdapter

//    private lateinit var recyclerActionsOfOther: RecyclerView
    private lateinit var actionsOfOtherAdapter: ActionsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //категории
        categoriesAdapter = GeneralAdapter(object : GeneralAdapter.Listener {
            override fun onItemClick(item: ItemCategory) {
                category = item
                viewModel.selectGeneralCategory()
            }
        })
        binding.homeCategories.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.homeCategories.adapter = categoriesAdapter

        //баннеры
        bannersAdapter = BannersAdapter(object : BannersAdapter.Listener {
            override fun onItemClick(position: Int) {
                /***/
            }
        })
        binding.homeBanners.adapter = bannersAdapter
        TabLayoutMediator(binding.homeBannersIndicator, binding.homeBanners) { _, _ -> }.attach()

        //товары недели
        actionsOfWeekAdapter = ActionsAdapter(object : ActionsAdapter.Listener {
            override fun onClickItem(position: Int) {
                /***/
            }
        })
        binding.homeActionsWeek.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.homeActionsWeek.adapter = actionsOfWeekAdapter

        //товары по акции
        actionsOfOtherAdapter = ActionsAdapter(object : ActionsAdapter.Listener {
            override fun onClickItem(position: Int) {
                /***/
            }
        })
        binding.homeActionsOther.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.homeActionsOther.adapter = actionsOfOtherAdapter

//        viewModel.categories.observe(viewLifecycleOwner, { adapter.setData(it) })
//        viewModel.navigate.observe(viewLifecycleOwner, {
//            val args = Bundle()
//            args.putParcelable("category", category)
//            navController.navigate(it, args)
//        })
//        viewModel.banners.observe(viewLifecycleOwner, {
//            bannersAdapter.setItems(it)
//        })
//        viewModel.actionsOfWeek.observe(viewLifecycleOwner, {
//            actionsOfWeekAdapter.setItems(it)
//        })
//        viewModel.actionsOfOther.observe(viewLifecycleOwner, {
//            actionsOfOtherAdapter.setItems(it)
//        })
    }

    override fun onStart() {
        super.onStart()
//        viewModel.loadBanners()
//        viewModel.loadCategories()
//        viewModel.loadActionsOfWeek()
//        viewModel.loadActionsOfOther()
    }

}