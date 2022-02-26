package com.tashuseyin.cryptocurrecny.presentation.coin_detail

import com.tashuseyin.cryptocurrecny.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
