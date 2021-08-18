package com.example.retrofitreturnhomework.ui.fragments.getdsec

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.retrofitreturnhomework.R
import com.example.retrofitreturnhomework.base.BaseFragment
import com.example.retrofitreturnhomework.databinding.FragmentGetItemBinding
import com.example.retrofitreturnhomework.ui.fragments.character.CharacterViewModel


class GetItem : BaseFragment<FragmentGetItemBinding, CharacterViewModel> (R.layout.fragment_get_item) {

    override val binding by viewBinding(FragmentGetItemBinding::bind)

    override val viewModel: CharacterViewModel by activityViewModels()

    private val args : GetItemArgs by navArgs()

    var id : Int? = null

    override fun setupViews() {
        id = args.id
        getData()
    }

    private fun getData() {
        viewModel.getCharacterArguments(id).observe(viewLifecycleOwner, {  rickyAndMortyCharacter ->
            Glide.with(binding.getImage).load(rickyAndMortyCharacter.image).into(binding.getImage)
            binding.getTitle.text = rickyAndMortyCharacter.name
        })
    }


}