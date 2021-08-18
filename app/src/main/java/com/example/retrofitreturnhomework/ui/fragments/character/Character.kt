package com.example.retrofitreturnhomework.ui.fragments.character

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
    override val viewModel: CharacterViewModel by activityViewModels()
    private var characterAdapter: CharacterAdapter = CharacterAdapter(this::onItemClick,this::onLongClick )

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
    private fun onItemClick(id: Int) {
        findNavController().navigate(
             CharacterDirections.actionCharacterToGetItem(id)
        )
    }
     private fun onLongClick (image : String) {
         findNavController().navigate(
             CharacterDirections.actionCharacterToDialogFrag(image)
         )
     }

}
