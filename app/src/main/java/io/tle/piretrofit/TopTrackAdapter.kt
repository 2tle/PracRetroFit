package io.tle.piretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.tle.piretrofit.databinding.ItemBinding
import io.tle.piretrofit.retrofit.dto.Track

class TopTrackAdapter(val data: List<Track>): RecyclerView.Adapter<TopTrackAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTrackAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val vh = ViewHolder(ItemBinding.bind(view))
        return vh
    }

    override fun onBindViewHolder(holder: TopTrackAdapter.ViewHolder, position: Int) {
        holder.binding.data = data[position]
        holder.binding.idx.text = (position+1).toString()
    }

    override fun getItemCount(): Int = data.size
    inner class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
    }
}