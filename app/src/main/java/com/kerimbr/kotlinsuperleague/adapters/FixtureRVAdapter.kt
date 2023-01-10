package com.kerimbr.kotlinsuperleague.adapters

import android.widget.BaseAdapter
import com.kerimbr.kotlinsuperleague.R
import com.kerimbr.kotlinsuperleague.adapters.base.BaseRVAdapter
import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureResponse
import com.kerimbr.kotlinsuperleague.databinding.ItemFixtureBinding
import com.kerimbr.kotlinsuperleague.utils.Utils
import com.kerimbr.kotlinsuperleague.utils.extensions.getImageFromUrl

class FixtureRVAdapter(
    val fixtures: List<FixtureResponse>,
    val onFixtureClicked: OnItemClickListener<FixtureResponse>
) : BaseRVAdapter<ItemFixtureBinding, FixtureResponse>(
    items = fixtures,
    onItemClickListener = onFixtureClicked
) {

    override val layoutRes: Int
        get() = R.layout.item_fixture

    override fun onBind(binding: ItemFixtureBinding, position: Int) {

        val item: FixtureResponse = fixtures[position]

        binding.fixture = item
        binding.fixtureCard.setOnClickListener {
            onFixtureClicked.onItemClick(item)
        }

        binding.homeTeamLogoImage.getImageFromUrl(item.teams.home.logo)
        binding.awayTeamLogoImage.getImageFromUrl(item.teams.away.logo)

        binding.time = Utils.getFixtureHour(item)
        binding.date = Utils.getFixtureDateStr(item)

    }

}