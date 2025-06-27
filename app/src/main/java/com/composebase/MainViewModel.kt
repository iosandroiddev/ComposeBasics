package com.composebase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {


    fun getBooks() {
        viewModelScope.launch {
            bookRepository.getBooks()
        }
    }
}