package com.tashuseyin.cryptocurrecny.presentation.coin_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.cryptocurrecny.data.remote.dto.TeamMember
import com.tashuseyin.cryptocurrecny.databinding.TeamMemberCardBinding

class TeamMemberAdapter(private val teamMemberList: List<TeamMember>) :
    RecyclerView.Adapter<TeamMemberAdapter.TeamMemberViewHolder>() {

    inner class TeamMemberViewHolder(private val binding: TeamMemberCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(teamMember: TeamMember) {
            binding.memberName.text = teamMember.name
            binding.memberPosition.text = teamMember.position
        }
    }

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
