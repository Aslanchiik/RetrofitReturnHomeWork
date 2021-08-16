package com.example.retrofitreturnhomework.ui.fragments.character

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitreturnhomework.databinding.FragmentCharacterBinding
import com.example.retrofitreturnhomework.ui.adapters.CharacterAdapter


class Character : Fragment() {

    lateinit var binding : FragmentCharacterBinding
    private val viewModel : CharacterViewModel by viewModels()
    var characterAdapter: CharacterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupRequest()
    }

    private fun setupRequest() {
        viewModel.getCharacter().observe(viewLifecycleOwner, { response ->
             characterAdapter.addAllList(response.results)

        })

    }

    private fun initialize() {
          binding.recView.apply {
              layoutManager = LinearLayoutManager(context)
              adapter = characterAdapter
          }

    }

}