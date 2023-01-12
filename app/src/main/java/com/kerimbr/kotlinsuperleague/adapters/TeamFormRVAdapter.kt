package com.kerimbr.kotlinsuperleague.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kerimbr.kotlinsuperleague.R

class TeamFormRVAdapter(
    private val formString: String
) : RecyclerView.Adapter<TeamFormRVAdapter.TeamFormViewHolder>() {

    inner class TeamFormViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return when (formString[position]) {
            'L' -> 0
            'W' -> 1
            else -> 2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamFormViewHolder {

        val view: View = when(viewType){
            0 -> LayoutInflater.from(parent.context)
                .inflate(R.layout.form_lose_view, parent, false)

            1 -> LayoutInflater.from(parent.context)
                .inflate(R.layout.form_win_view, parent, false)

            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.form_draw_view, parent, false)
        }

        return TeamFormViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamFormViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return formString.length
    }

}
