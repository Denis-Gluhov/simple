package ru.magizoo.magizoo.presentation.subcategory

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.magizoo.R

@AndroidEntryPoint
class SubCategoryFragment: BaseFragment(R.layout.fragment_subcategory) {

    companion object {
        private const val CATEGORY = "category"
    }

    private val viewModel: SubCategoryViewModel by viewModels()

    private lateinit var title: TextView
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var productList: RecyclerView
    private lateinit var adapter: SubCategoryAdapter
    private lateinit var selectedItemSubCategory: ItemSubCategory
//    private var category: ItemCategory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        category = requireArguments().getParcelable(CATEGORY)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        title = view.findViewById(R.id.subcategory_title)
        refreshLayout = view.findViewById(R.id.subcategory_refresh_layout)
        productList = view.findViewById(R.id.subcategory_list)

        adapter = SubCategoryAdapter(object : SubCategoryAdapter.Listener {
            override fun onClickItem(item: ItemSubCategory) {
                selectedItemSubCategory = item
                viewModel.clickItem()
            }
        })
        productList.addItemDecoration(DividerItemDecoration(requireActivity(),
            LinearLayoutManager.VERTICAL))
        productList.adapter = adapter

//        refreshLayout.setOnRefreshListener {
//            category?.let {
//                viewModel.loadSubCategory(it.id)
//            }
//        }

//        category?.let {
//            title.text = it.name
//        }

        viewModel.loading.observe(viewLifecycleOwner, { refreshLayout.isRefreshing = it })
        viewModel.subCategory.observe(viewLifecycleOwner, { adapter.setItems(it) })
        viewModel.navigate.observe(viewLifecycleOwner, {
//            val args = Bundle()
//            args.putParcelable("subCategory", selectedItemSubCategory)
//            navController.navigate(it, args)
        })
    }

    override fun onStart() {
        super.onStart()
//        category?.let {
//            viewModel.loadSubCategory(it.id)
//        }
    }
}