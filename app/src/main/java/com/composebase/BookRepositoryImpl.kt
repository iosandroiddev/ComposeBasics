package com.composebase

import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val apiService: BookApiService
) : BookRepository {

    override suspend fun getBooks() {
    }
}