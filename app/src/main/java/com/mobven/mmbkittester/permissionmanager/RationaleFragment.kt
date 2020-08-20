package com.mobven.mmbkittester.permissionmanager

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobven.mmbkittester.R
import com.mobven.permissionmanager.PermissionManager
import kotlinx.android.synthetic.main.fragment_permission_rationale.*

class RationaleFragment : Fragment() {

    private var permission: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permission = arguments?.getString(ARG_KEY_PERMISSION)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_permission_rationale, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtRationale.text = when (permission) {
            Manifest.permission.CAMERA -> "We need CAMERA permission to see your beautiful face"
            Manifest.permission.ACCESS_FINE_LOCATION -> "We are very curious about where are you now, so we need LOCATION services permission"
            Manifest.permission.READ_CONTACTS -> "We need CONTACTS permission to send your contacts very funny messages"
            Manifest.permission.RECORD_AUDIO -> "We need MICROPHONE permission to hear your beautiful voice"
            else -> ""
        }
        btnOk.setOnClickListener {
            permission?.let {
                PermissionManager.userSawRationale(it)
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .remove(this)
                    .commit()
            }
        }
    }


    companion object {
        const val ARG_KEY_PERMISSION = "permission"

        fun newInstance(permission: String): RationaleFragment {
            return RationaleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_KEY_PERMISSION, permission)
                }
            }
        }
    }

}