package io.tle.piretrofit.retrofit

import io.tle.piretrofit.retrofit.dto.TopTracksDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITopTrack {
    @GET("2.0")
    fun getTopTracks(@Query("method") method: String = "chart.gettoptracks", @Query("api_key") key: String, @Query("format") format: String = "json") : Call<TopTracksDTO>
}