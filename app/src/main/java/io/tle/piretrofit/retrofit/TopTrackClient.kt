package io.tle.piretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TopTrackClient {
    private const val baseUrl = "https://ws.audioscrobbler.com/"
    private var instance : Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    fun getTopTrackInterface() : ITopTrack = instance.create(ITopTrack::class.java)
}
