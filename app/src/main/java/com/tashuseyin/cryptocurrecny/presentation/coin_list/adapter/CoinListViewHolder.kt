package com.tashuseyin.cryptocurrecny.presentation.coin_list.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.cryptocurrecny.databinding.CoinCardBinding
import com.tashuseyin.cryptocurrecny.domain.model.Coin

class CoinListViewHolder(private val binding: CoinCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(coin: Coin, onItemClickListener: (String) -> Unit) {
        binding.coinName.text = "${coin.rank}. ${coin.name} (${coin.symbol})"
        binding.coinIsActive.text = if (coin.is_active) "active" else "inactive"
        binding.coinIsActive.setTextColor(if (coin.is_active) Color.GREEN else Color.RED)

        binding.card.setOnClickListener {
            onItemClickListener(coin.id)
        }
    }
}