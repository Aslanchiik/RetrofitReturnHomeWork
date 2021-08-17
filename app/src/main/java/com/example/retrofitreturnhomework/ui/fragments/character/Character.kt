package com.example.retrofitreturnhomework.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.retrofitreturnhomework.R
import com.example.retrofitreturnhomework.base.BaseFragment
import com.example.retrofitreturnhomework.databinding.FragmentCharacterBinding
import com.example.retrofitreturnhomework.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Character :  BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding (FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private var characterAdapter: CharacterAdapter = CharacterAdapter()

    override fun setupViews() {
        binding.recView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }
    }

    override fun setupRequest() {
        lifecycleScope.launch {
              viewModel.hiltCharacters().collectLatest {
                  characterAdapter.submitData(it)
              }
        }
    }

}
