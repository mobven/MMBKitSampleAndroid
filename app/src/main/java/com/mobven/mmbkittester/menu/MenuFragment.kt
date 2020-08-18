package com.mobven.mmbkittester.menu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mobven.localizeit.LocalizeIt
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LocalizeIt.selectedLanguage.observe(viewLifecycleOwner, Observer {
            recyclerMenu.adapter = MenuAdapter(
                arguments?.getParcelableArrayList(ARG_KEY_MENU_ITEMS) ?: listOf()
            ) { menuItem ->
                menuItem.redirectClass?.let {
                    startActivity(Intent(requireContext(), it))
                } ?: run {
                    if (menuItem.subItems.isNullOrEmpty().not()) {
                        requireActivity().supportFragmentManager.beginTransaction().apply {
                            add(R.id.frameContainer, newInstance(menuItem.subItems))
                            addToBackStack(null)
                            commit()
                        }
                    }
                }
            }
        })
    }

    companion object {

        private const val ARG_KEY_MENU_ITEMS = "menu_items"

        fun newInstance(items: ArrayList<MenuItem>) = MenuFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(ARG_KEY_MENU_ITEMS, items)
            }
        }
    }
}
