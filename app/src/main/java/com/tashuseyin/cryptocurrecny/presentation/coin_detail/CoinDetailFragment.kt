package com.tashuseyin.cryptocurrecny.presentation.coin_detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.google.android.material.chip.Chip
import com.tashuseyin.cryptocurrecny.R
import com.tashuseyin.cryptocurrecny.databinding.FragmentCoinDetailBinding
import com.tashuseyin.cryptocurrecny.presentation.bindingadapter.BindingFragment
import com.tashuseyin.cryptocurrecny.presentation.coin_detail.adapter.TeamMemberAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CoinDetailFragment : BindingFragment<FragmentCoinDetailBinding>() {
    private val coinDetailViewModel: CoinDetailViewModel by viewModels()

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentCoinDetailBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayoutManager = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.recyclerview.layoutManager = linearLayoutManager
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            coinDetailViewModel.state.collect { state ->
                binding.apply {
                    state.coin?.let { coin ->
                        val coinTitle = "${coin.rank}. ${coin.name} (${coin.symbol})"
                        coinName.text = coinTitle
                        coinIsActive.text = if (coin.is_active) "activate" else "inactivate"
                        coinIsActive.setTextColor(if (coin.is_active) Color.GREEN else Color.RED)
                        coinDescription.text = coin.description

                        tagsText.isVisible = coin.tags?.isNotEmpty() ?: false
                        coin.tags?.let { tags ->
                            tags.forEach { tag ->
                                dynamicChpGroup(tag)
                            }
                        }

                        teamMember.isVisible = coin.team?.isNotEmpty() ?: false
                        val adapter = coin.team?.let { team ->
                            TeamMemberAdapter(team)
                        }
                        binding.recyclerview.adapter = adapter
                    }
                    progressBar.isVisible = state.isLoading

                    if (state.error.isNotBlank()) {
                        errorText.text = state.error
                    }
                }
            }
        }
    }


    private fun dynamicChpGroup(text: String) {
        val chip = layoutInflater.inflate(R.layout.item_chip, binding.chipGroup, false) as Chip
        chip.text = text
        binding.chipGroup.addView(chip)
    }


}