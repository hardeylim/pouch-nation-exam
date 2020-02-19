package com.example.pouchnationexam.usecase.api

import com.example.pouchnationexam.BuildConfig
import com.example.pouchnationexam.BuildConfig.CLIENT_ID
import com.example.pouchnationexam.BuildConfig.CLIENT_SECRET
import com.example.pouchnationexam.usecase.interceptor.BasicAuthInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AuthenticationApiModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(loggingInterceptor)
        builder.readTimeout(60, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(BuildConfig.TOKEN_URL)
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}