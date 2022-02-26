package com.tashuseyin.cryptocurrecny.domain.use_case.get_coins

import com.tashuseyin.cryptocurrecny.common.Resource
import com.tashuseyin.cryptocurrecny.data.remote.dto.toCoin
import com.tashuseyin.cryptocurrecny.domain.model.Coin
import com.tashuseyin.cryptocurrecny.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

//    fun getCoinList(): Flow<Resource<List<Coin>>> = flow {
//        try {
//            emit(Resource.Loading())
//            val coins = repository.getCoins().map { it.toCoin() }
//            emit(Resource.Success(coins))
//        } catch (e: HttpException) {
//            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
//        } catch (e: IOException) {
//            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
//        }
//    }


}