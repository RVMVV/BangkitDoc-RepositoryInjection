package com.code.newsapp.data.di

import android.content.Context
import com.code.newsapp.data.NewsRepository
import com.code.newsapp.data.local.room.NewsDatabase
import com.code.newsapp.data.remote.retrofit.ApiConfig
import com.code.newsapp.utils.AppExecutors


object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService =  ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
        return NewsRepository.getInstance(apiService,dao,appExecutors)
    }
}