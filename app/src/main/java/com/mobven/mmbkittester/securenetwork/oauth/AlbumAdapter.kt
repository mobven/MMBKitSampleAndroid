package com.mobven.mmbkittester.securenetwork.oauth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.securenetwork.oauth.model.Track
import kotlinx.android.synthetic.main.item_track.view.*

class AlbumAdapter(private val data: ArrayList<Track>) :
    RecyclerView.Adapter<AlbumAdapter.TrackViewHolder>() {

    class TrackViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(track: Track) {
            view.txtName.text = track.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_track,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun setItems(list: List<Track>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun setItemsError(list: Track?) {
        data.clear()
        list?.let { data.add(it) }
        notifyDataSetChanged()
    }

}