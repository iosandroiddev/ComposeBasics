package com.composebase

interface BookRepository {

    suspend fun getBooks()
}