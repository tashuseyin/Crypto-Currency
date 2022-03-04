package com.tashuseyin.cryptocurrecny.presentation.coin_list.adapter

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.cryptocurrecny.databinding.CoinCardBinding
import com.tashuseyin.cryptocurrecny.domain.model.Coin

class CoinListViewHolder(private val binding: CoinCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(coin: Coin, onItemClickListener: (String) -> Unit) {
        val coinTitle = "${coin.rank}. ${coin.name} (${coin.symbol})"
        binding.coinName.text = coinTitle
        binding.coinIsActive.text = if (coin.is_active) "active" else "inactive"
        binding.coinIsActive.setTextColor(if (coin.is_active) Color.GREEN else Color.RED)

        binding.card.setOnClickListener {
            onItemClickListener(coin.id)
        }
    }
}