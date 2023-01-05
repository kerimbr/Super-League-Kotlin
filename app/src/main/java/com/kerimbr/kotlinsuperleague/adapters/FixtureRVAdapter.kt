package com.kerimbr.kotlinsuperleague.adapters

import android.widget.BaseAdapter
import com.kerimbr.kotlinsuperleague.R
import com.kerimbr.kotlinsuperleague.adapters.base.BaseRVAdapter
import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureResponse
import com.kerimbr.kotlinsuperleague.databinding.ItemFixtureBinding

class FixtureRVAdapter(
    val fixtures: List<FixtureResponse>,
    val onFixtureClicked: OnItemClickListener<FixtureResponse>
) : BaseRVAdapter<ItemFixtureBinding, FixtureResponse>(
    items = fixtures,
    onItemClickListener = onFixtureClicked
) {

    override val layoutRes: Int
        get() = R.layout.item_fixture

    override fun onBind(binding: ItemFixtureBinding, item: FixtureResponse) {
        binding.fixture = item
    }

}