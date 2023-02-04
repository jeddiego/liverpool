package com.diegolara.liverpool.main.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.diegolara.core.presentation.BaseFragment
import com.diegolara.liverpool.databinding.FragmentMainBinding
import com.diegolara.liverpool.main.adapters.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {
    private val viewModel: MainViewModel by viewModels()

    override fun initBinding(): FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)

    override fun initView(view: View, savedInstanceState: Bundle?) {
        loadData()
    }

    private fun loadData() {
        binding.apply {
            val productsAdapter = ProductsAdapter(requireContext()) { }

            viewModel.getProductsByPage.observe(viewLifecycleOwner) {
                productsAdapter.submitList(it)
            }

            viewModel.getProductsByPage(1)

            rvMainProduct.adapter = productsAdapter
        }
    }
}