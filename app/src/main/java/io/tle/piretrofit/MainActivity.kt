package io.tle.piretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import io.tle.piretrofit.databinding.ActivityMainBinding
import io.tle.piretrofit.retrofit.TopTrackClient
import io.tle.piretrofit.retrofit.dto.TopTracksDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val call : Call<TopTracksDTO> = TopTrackClient.service.getTopTracks(key ="563f17153e9c60240d5e29bb1a508549")
        call.enqueue(object : Callback<TopTracksDTO> {
            override fun onResponse(call: Call<TopTracksDTO>, response: Response<TopTracksDTO>) {
                Log.d(">",response.code().toString())
                if(response.code() == 200) {
                    val data : TopTracksDTO = response.body()!!
                    val track = data.tracks.track
                    binding.recycler.adapter = TopTrackAdapter(track)
                    binding.recycler.adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<TopTracksDTO>, t: Throwable) {
                Log.e(">",t.message.toString())
            }
        })

    }
}
