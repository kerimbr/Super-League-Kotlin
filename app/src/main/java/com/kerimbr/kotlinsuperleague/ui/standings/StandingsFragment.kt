package com.kerimbr.kotlinsuperleague.ui.standings


import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerimbr.kotlinsuperleague.adapters.StandingsRVAdapter
import com.kerimbr.kotlinsuperleague.data.dto.standings.Standing
import com.kerimbr.kotlinsuperleague.databinding.FragmentStandingsBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StandingsFragment : BaseFragment() {

    private var _binding: FragmentStandingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StandingsViewModel by viewModels()


    override fun initBinding(): ViewDataBinding {
        _binding = FragmentStandingsBinding.inflate(layoutInflater)
        return binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolBar()
        observeUI()
    }


    private fun setupToolBar() {
        binding.standingsToolbar.setNavigationOnClickListener {
            println("Navigation icon clicked")
        }
    }

    private fun observeUI() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getStandings()
            viewModel.state.collect { state ->
                if (state.isLoading) {
                    binding.standingsLinearProgressIndicator.visibility = View.VISIBLE
                    binding.standingsRecyclerView.visibility = View.GONE
                } else {
                    binding.standingsLinearProgressIndicator.visibility = View.GONE
                }
                if (state.standings != null) {
                    binding.standingsRecyclerView.visibility = View.VISIBLE
                    initRecyclerView(state.standings)
                }
            }
        }
    }

    private fun initRecyclerView(standings: List<Standing>) {
        binding.standingsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = StandingsRVAdapter(
                standings = standings,
                onStandingClicked = null
            )
        }
    }



}