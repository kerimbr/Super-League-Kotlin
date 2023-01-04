package com.kerimbr.kotlinsuperleague.di

import androidx.databinding.ktx.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kerimbr.kotlinsuperleague.core.*
import com.kerimbr.kotlinsuperleague.data.remote.service.FootballAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        builder.addInterceptor {
            val request = it
                .request()
                .newBuilder()
                .addHeader("x-rapidapi-host", API_HOST)
                .addHeader("x-apisports-key", API_KEY)
                .build()
            it.proceed(request)
        }
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }


    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideFootballAPIService(retrofit: Retrofit): FootballAPIService {
        return retrofit.create(FootballAPIService::class.java)
    }

}