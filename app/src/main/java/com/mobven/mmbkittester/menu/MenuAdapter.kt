package com.mobven.mmbkittester.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobven.localizeit.setLocalizedText
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onItemClickListener: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
        MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_menu,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MenuViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener { onItemClickListener(items[absoluteAdapterPosition]) }
        }

        fun bind(item: MenuItem) {
            if (item.isLocalized) {
                view.txtName.setLocalizedText(item.name)
            } else {
                view.txtName.text = item.name
            }
        }
    }

}

