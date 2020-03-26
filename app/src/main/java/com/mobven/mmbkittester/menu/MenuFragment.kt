package com.mobven.mmbkittester.menu

import android.os.Bundle
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {



    companion object {

        private const val ARG_KEY_MENU_ITEMS = "menu_items"

        fun newInstance(items: ArrayList<MenuItem>) = MenuFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(ARG_KEY_MENU_ITEMS, items)
            }
        }
    }
}
