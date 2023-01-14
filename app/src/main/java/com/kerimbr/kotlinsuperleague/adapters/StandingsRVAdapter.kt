package com.kerimbr.kotlinsuperleague.adapters


import android.graphics.Typeface
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
            setRowTextStyle(binding, true)
        } else {

            val item: Standing = standings[position - 1]

            binding.isHeader = false
            setRowTextStyle(binding, false)
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

    private fun setRowTextStyle(binding: ItemStandingsTableRowBinding, isHeader: Boolean) {
        if (isHeader){
            binding.standingsTableRowPosition.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowTeamName.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowMP.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowW.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowD.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowL.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowGF.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowGA.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowGD.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowP.typeface = Typeface.DEFAULT_BOLD
            binding.standingsTableRowForm.typeface = Typeface.DEFAULT_BOLD
        }else{
            binding.standingsTableRowPosition.typeface = Typeface.DEFAULT
            binding.standingsTableRowTeamName.typeface = Typeface.DEFAULT
            binding.standingsTableRowMP.typeface = Typeface.DEFAULT
            binding.standingsTableRowW.typeface = Typeface.DEFAULT
            binding.standingsTableRowD.typeface = Typeface.DEFAULT
            binding.standingsTableRowL.typeface = Typeface.DEFAULT
            binding.standingsTableRowGF.typeface = Typeface.DEFAULT
            binding.standingsTableRowGA.typeface = Typeface.DEFAULT
            binding.standingsTableRowGD.typeface = Typeface.DEFAULT
            binding.standingsTableRowP.typeface = Typeface.DEFAULT
            binding.standingsTableRowForm.typeface = Typeface.DEFAULT
        }
    }
}
