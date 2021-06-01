package ru.magizoo.magizoo.presentation.product_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.magizoo.R
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.magizoo.presentation.subcategory.ItemSubCategory

@AndroidEntryPoint
class ProductListFragment: BaseFragment(R.layout.fragment_product_list) {

    companion object {
        private const val SUB_CATEGORY = "subCategory"
    }

    private val viewModel: ProductListViewModel by viewModels()

    private lateinit var title: TextView
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var productList: RecyclerView
    private lateinit var adapter: ProductListAdapter
    private var subCategory: ItemSubCategory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subCategory = requireArguments().getParcelable(SUB_CATEGORY)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        title = view.findViewById(R.id.product_list_title)
        refreshLayout = view.findViewById(R.id.product_list_refresh_layout)
        productList = view.findViewById(R.id.product_list_recycler)
        subCategory?.let { title.text = it.name }
        refreshLayout.setOnRefreshListener {
            subCategory?.let { viewModel.loadProducts(it.id) }
        }
        adapter = ProductListAdapter()
        productList.addItemDecoration(DividerItemDecoration(requireActivity(),
            LinearLayoutManager.VERTICAL)
        )
        productList.adapter = adapter

        viewModel.products.observe(viewLifecycleOwner, {
            adapter.setItems(it)
        })
        viewModel.loading.observe(viewLifecycleOwner, {
            refreshLayout.isRefreshing = it
        })

    }

    override fun onStart() {
        super.onStart()
        subCategory?.let { viewModel.loadProducts(it.id) }
    }
}