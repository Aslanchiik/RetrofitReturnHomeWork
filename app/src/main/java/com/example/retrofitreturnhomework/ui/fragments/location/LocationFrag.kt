package com.example.retrofitreturnhomework.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.retrofitreturnhomework.R
import com.example.retrofitreturnhomework.base.BaseFragment
import com.example.retrofitreturnhomework.databinding.FragmentLocationBinding
import com.example.retrofitreturnhomework.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch



@AndroidEntryPoint
class LocationFrag : BaseFragment<FragmentLocationBinding, LocationViewModel> (R.layout.fragment_location) {
    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter: LocationAdapter = LocationAdapter()

    override fun setupViews() {
        binding.recViewLocation.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = locationAdapter
        }
    }

    override fun setupRequest() {
        lifecycleScope.launch {
            viewModel.hiltLocation().collectLatest {
                locationAdapter.submitData(it)
            }
        }
    }
}