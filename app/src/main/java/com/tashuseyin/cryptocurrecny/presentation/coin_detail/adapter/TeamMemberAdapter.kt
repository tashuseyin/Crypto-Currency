package com.tashuseyin.cryptocurrecny.presentation.coin_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.cryptocurrecny.data.remote.dto.TeamMember
import com.tashuseyin.cryptocurrecny.databinding.TeamMemberCardBinding

class TeamMemberAdapter(private val teamMemberList: List<TeamMember>) :
    RecyclerView.Adapter<TeamMemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        val binding =
            TeamMemberCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        holder.bind(teamMemberList[position])
    }

    override fun getItemCount() = teamMemberList.size
}
