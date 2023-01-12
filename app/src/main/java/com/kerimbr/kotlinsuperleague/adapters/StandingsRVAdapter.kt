package com.kerimbr.kotlinsuperleague.adapters


import androidx.recyclerview.widget.LinearLayoutManager
import com.kerimbr.kotlinsuperleague.R
import com.kerimbr.kotlinsuperleague.adapters.base.BaseRVAdapter
import com.kerimbr.kotlinsuperleague.data.dto.standings.Standing
import com.kerimbr.kotlinsuperleague.databinding.ItemStandingsTableRowBinding
import com.kerimbr.kotlinsuperleague.utils.extensions.getImageFromUrl

class StandingsRVAdapter(
    private val standings: List<Standing>,
    private val onStandingClicked: OnItemClickListener<Standing>?
) : BaseRVAdapter<ItemStandingsTableRowBinding, Standing>(
    items = standings,
    onItemClickListener = onStandingClicked
) {


    override val layoutRes: Int
        get() = R.layout.item_standings_table_row

    override fun onBind(binding: ItemStandingsTableRowBinding, position: Int) {

        if (position == 0){
            binding.isHeader = true
        } else {

            val item: Standing = standings[position - 1]

            binding.isHeader = false
            binding.standing = item

            val formAdapter = TeamFormRVAdapter(
                formString = item.form,
            )

            binding.standingsItemFormList.layoutManager = LinearLayoutManager(
                binding.root.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            binding.standingsItemFormList.adapter = formAdapter

            binding.standingsTableRowTeamLogo.getImageFromUrl(item.team.logo)
            if (onStandingClicked != null) {
                binding.standingsTableRow.setOnClickListener {
                    onStandingClicked.onItemClick(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }
}
