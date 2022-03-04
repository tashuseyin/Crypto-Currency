package com.tashuseyin.cryptocurrecny.presentation.coin_detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.cryptocurrecny.data.remote.dto.TeamMember
import com.tashuseyin.cryptocurrecny.databinding.TeamMemberCardBinding

class TeamMemberViewHolder(private val binding: TeamMemberCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(teamMember: TeamMember) {
        binding.memberName.text = teamMember.name
        binding.memberPosition.text = teamMember.position
    }
}