package com.example.retrofitreturnhomework.ui.fragments.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.retrofitreturnhomework.data.repositories.LocationsRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LocationViewModel
    @Inject constructor(private var repos: LocationsRepos) : ViewModel() {

      fun hiltLocation ()  = repos.fetchLocation().cachedIn(viewModelScope)

    }
