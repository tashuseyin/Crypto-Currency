package com.tashuseyin.cryptocurrecny.presentation.coin_list

import com.tashuseyin.cryptocurrecny.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
