package ru.magizoo.feature_catalog.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.feature_catalog.R

@AndroidEntryPoint
class CatalogFragment: BaseFragment(R.layout.fragment_catalog) {
    override val isVisibleBottomNavigationBar = true

    private val viewModel: CatalogViewModel by viewModels()

    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var catalogCategoryList: RecyclerView
    private lateinit var adapter: CatalogAdapter
//    private lateinit var category: ItemCategory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        refreshLayout = view.findViewById(R.id.catalog_category_refresh_layout)
//        catalogCategoryList = view.findViewById(R.id.catalog_category_list)
//        adapter = CatalogAdapter(object : CatalogAdapter.Listener {
//            override fun onClickItem(item: ItemCategory) {
//                category = item
//                viewModel.clickItem()
//            }
//        })
//        catalogCategoryList.addItemDecoration(DividerItemDecoration(requireActivity(),
//            LinearLayoutManager.VERTICAL))
//        catalogCategoryList.adapter = adapter
//        refreshLayout.setOnRefreshListener { viewModel.loadCategory() }

//        viewModel.categories.observe(viewLifecycleOwner, { adapter.setItems(it) })
//        viewModel.loading.observe(viewLifecycleOwner, { refreshLayout.isRefreshing = it })
//        viewModel.navigate.observe(viewLifecycleOwner, {
//            val args = Bundle()
//            args.putParcelable("category", category)
//            navController.navigate(it, args)
//        })
    }

}