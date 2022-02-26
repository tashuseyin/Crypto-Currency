package com.tashuseyin.cryptocurrecny.domain.repository

import com.tashuseyin.cryptocurrecny.data.remote.dto.CoinDetailDto
import com.tashuseyin.cryptocurrecny.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}