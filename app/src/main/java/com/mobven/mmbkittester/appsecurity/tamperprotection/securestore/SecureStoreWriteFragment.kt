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
import kotlinx.android.synthetic.main.fragment_secure_store_write.*
import java.lang.NumberFormatException

class SecureStoreWriteFragment : Fragment() {

    var selectedType: StoreType = StoreType.STRING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_secure_store_write, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTypeSpinner()
        btnWrite.setOnClickListener {
            if (edtKey.text.isNullOrEmpty().not()) {
                if (edtValue.text.isNullOrEmpty().not()) {
                    handleWrite(edtKey.text.toString(), edtValue.text.toString(), selectedType)
                } else {
                    requireContext().showToast("Pref value can not be empty")
                }
            } else {
                requireContext().showToast("Pref key can not be empty")
            }
        }
    }

    private fun handleWrite(key: String, value: String, type: StoreType) {
        when (type) {
            StoreType.STRING -> {
                AppSecurity.putEncryptedString(key, value)
                requireContext().showToast("Wrote successfully")
            }
            StoreType.BOOLEAN -> {
                AppSecurity.putEncryptedBoolean(key, value.toBoolean())
                requireContext().showToast("Wrote successfully")
            }
            StoreType.INT -> try {
                AppSecurity.putEncryptedInt(key, value.toInt())
                requireContext().showToast("Wrote successfully")
            } catch (ex: NumberFormatException) {
                requireContext().showToast("Value is not an integer")
            }
            StoreType.FLOAT -> try {
                AppSecurity.putEncryptedFloat(key, value.toFloat())
                requireContext().showToast("Wrote successfully")
            } catch (ex: NumberFormatException) {
                requireContext().showToast("Value is not a float")
            }
            StoreType.LONG -> try {
                AppSecurity.putEncryptedLong(key, value.toLong())
                requireContext().showToast("Wrote successfully")
            } catch (ex: NumberFormatException) {
                requireContext().showToast("Value is not a long")
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
        fun newInstance() = SecureStoreWriteFragment()
    }

}