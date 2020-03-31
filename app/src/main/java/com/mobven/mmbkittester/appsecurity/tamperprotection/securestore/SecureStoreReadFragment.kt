package com.mobven.mmbkittester.appsecurity.tamperprotection.securestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import kotlinx.android.synthetic.main.fragment_secure_store_read.*

class SecureStoreReadFragment: Fragment() {

    var selectedType: StoreType = StoreType.STRING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_secure_store_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTypeSpinner()

        btnRead.setOnClickListener {
            if (edtKey.text.isNullOrEmpty().not()) {
                val key = edtKey.text.toString()
                txtValue.text = when (selectedType) {
                    StoreType.STRING -> AppSecurity.getEncryptedString(key, null)
                    StoreType.BOOLEAN -> AppSecurity.getEncryptedBoolean(key, false).toString()
                    StoreType.INT -> AppSecurity.getEncryptedInt(key, Int.MIN_VALUE).toString()
                    StoreType.FLOAT -> AppSecurity.getEncryptedFloat(key, Float.NEGATIVE_INFINITY).toString()
                    StoreType.LONG -> AppSecurity.getEncryptedLong(key, Long.MIN_VALUE).toString()
                }
            } else {
                requireContext().showToast("Pref key can not be empty")
            }
        }
    }

    private fun initTypeSpinner() {
        spinnerType.adapter = ArrayAdapter<StoreType>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            StoreType.values()
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedType = StoreType.values()[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    companion object {
        fun newInstance() = SecureStoreReadFragment()
    }

}