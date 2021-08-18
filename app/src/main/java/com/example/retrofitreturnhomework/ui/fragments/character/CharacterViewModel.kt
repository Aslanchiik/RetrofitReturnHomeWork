package com.example.retrofitreturnhomework.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.retrofitreturnhomework.data.repositories.CharacterRepos
import com.example.retrofitreturnhomework.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject  constructor(private var repository : CharacterRepos) : ViewModel() {

    fun hiltCharacters()  = repository.fetchCharacters().cachedIn(viewModelScope)

    fun getCharacterArguments (id : Int? = null) : MutableLiveData<CharacterModel> {
        return repository.fetchGetDescription(id)
    }
}



