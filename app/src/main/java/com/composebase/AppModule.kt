package com.composebase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBookRepository(bookApiService: BookApiService): BookRepository {
        return BookRepositoryImpl(bookApiService)
    }

    @Provides
    @Singleton
    fun provideBookApiService(): BookApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .build()
            .create(BookApiService::class.java)
    }
}