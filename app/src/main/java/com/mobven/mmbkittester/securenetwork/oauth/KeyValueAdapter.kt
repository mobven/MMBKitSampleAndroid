package com.mobven.mmbkittester.securenetwork.oauth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.item_key_value.view.*

class KeyValueAdapter : RecyclerView.Adapter<KeyValueAdapter.KeyValueViewHolder>() {

    var pair: Pair<String, String>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyValueViewHolder {
        return KeyValueViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_key_value, parent, false)
        )
    }

    override fun getItemCount(): Int = pair?.let { 1 } ?: 0

    override fun onBindViewHolder(holder: KeyValueViewHolder, position: Int) {
        pair?.let(holder::bind)
    }

    class KeyValueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(pair: Pair<String, String>) {
            itemView.titleLabel.keyText = pair.first
            itemView.titleLabel.valueText = pair.second
        }
    }
}

