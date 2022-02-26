package com.tashuseyin.cryptocurrecny.domain.model

import com.tashuseyin.cryptocurrecny.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val description: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>,
)