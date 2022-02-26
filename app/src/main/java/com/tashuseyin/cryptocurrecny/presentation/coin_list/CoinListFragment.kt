package com.tashuseyin.cryptocurrecny.presentation.coin_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.tashuseyin.cryptocurrecny.databinding.FragmentCoinListBinding
import com.tashuseyin.cryptocurrecny.presentation.bindingadapter.BindingFragment
import com.tashuseyin.cryptocurrecny.presentation.coin_list.adapter.CoinListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinListFragment : BindingFragment<FragmentCoinListBinding>() {
    private val coinListViewModel: CoinListViewModel by viewModels()

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentCoinListBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            coinListViewModel.state.collect { state ->
                if (state.coins.isNotEmpty()) {
                    val adapter = CoinListAdapter(state.coins) { coinId ->
                        findNavController().navigate(
                            CoinListFragmentDirections.actionCoinListFragmentToCoinDetailFragment(coinId)
                        )
                    }
                    binding.recyclerview.adapter = adapter
                }
                if (state.error.isNotBlank()) {
                    binding.errorText.text = state.error
                }
                binding.progressBar.isVisible = state.isLoading
            }
        }
    }

}