package com.tashuseyin.cryptocurrecny.presentation.coin_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.cryptocurrecny.databinding.CoinCardBinding
import com.tashuseyin.cryptocurrecny.domain.model.Coin

class CoinListAdapter(
    private val coinList: List<Coin>,
    private val onItemClickListener: (String) -> Unit
) :
    RecyclerView.Adapter<CoinListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        val binding = CoinCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        holder.bind(coinList[position], onItemClickListener)
    }

    override fun getItemCount() = coinList.size

}