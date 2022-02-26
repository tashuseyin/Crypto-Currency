package com.tashuseyin.cryptocurrecny.data.repository

import com.tashuseyin.cryptocurrecny.data.remote.CoinPaprikaApi
import com.tashuseyin.cryptocurrecny.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins() = api.getCoins()

    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId)
}
