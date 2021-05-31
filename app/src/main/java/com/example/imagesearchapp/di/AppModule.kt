package com.example.imagesearchapp.di

import com.example.imagesearchapp.api.UnSplashApi
import com.example.imagesearchapp.others.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

//    @Singleton
//    @Provides
//    fun provideApi(): Api =
//        Retrofit.Builder().baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(Api::class.java)

    @Singleton
    @Provides
    fun provideRetrofit() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): UnSplashApi = retrofit.create(UnSplashApi::class.java)

}