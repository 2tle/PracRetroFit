package io.tle.piretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TopTrackClient {
    private const val baseUrl = "https://ws.audioscrobbler.com/"
    private var instance : Retrofit? = null
    fun getTopTrackInterface() : ITopTrack = getInstance().create(ITopTrack::class.java)

    private fun getInstance() : Retrofit {
        if(instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return instance!!
    }
}