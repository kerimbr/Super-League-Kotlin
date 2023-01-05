package com.kerimbr.kotlinsuperleague.ui.fixture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerimbr.kotlinsuperleague.adapters.FixtureRVAdapter
import com.kerimbr.kotlinsuperleague.adapters.base.BaseRVAdapter
import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureResponse
import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel
import com.kerimbr.kotlinsuperleague.databinding.FragmentFixtureBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FixtureFragment : BaseFragment() {

    private var _binding: FragmentFixtureBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FixtureViewModel by viewModels()

    override fun initBinding(): ViewDataBinding {
        _binding = FragmentFixtureBinding.inflate(layoutInflater)
        return binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUI()
    }

    private fun observeUI() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllFixtures()
            viewModel.fixtureViewState.collect { state ->
                if (state.isLoading) {
                    binding.fixtureLinearProgressIndicator.visibility = View.VISIBLE
                    binding.fixtureCircularProgressIndicator.visibility = View.VISIBLE
                    binding.fixtureRecyclerView.visibility = View.GONE
                } else {
                    binding.fixtureLinearProgressIndicator.visibility = View.GONE
                    binding.fixtureCircularProgressIndicator.visibility = View.GONE
                }

                if (state.fixtures != null) {
                    binding.fixtureRecyclerView.visibility = View.VISIBLE
                    initRecyclerView(state.fixtures)

                }

            }
        }
    }

    private fun initRecyclerView(fixtures: FixtureRootModel) {
        val recyclerView = binding.fixtureRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = FixtureRVAdapter(
            fixtures = fixtures.fixtureResponse,
            onFixtureClicked = onClickItem()
        )
    }

    private fun onClickItem(): BaseRVAdapter.OnItemClickListener<FixtureResponse> {
        return object : BaseRVAdapter.OnItemClickListener<FixtureResponse> {
            override fun onItemClick(item: FixtureResponse) {
                println("Clicked item: ${item.teams.home.name} vs ${item.teams.away.name}")
            }
        }
    }

}