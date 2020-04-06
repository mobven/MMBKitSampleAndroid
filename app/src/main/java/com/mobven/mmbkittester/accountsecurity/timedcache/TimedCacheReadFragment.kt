package com.mobven.mmbkittester.accountsecurity.timedcache

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import kotlinx.android.synthetic.main.fragment_timed_cache_read.*

class TimedCacheReadFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_timed_cache_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGet.setOnClickListener {
            if (edtKey.text.isNullOrEmpty().not()) {
                val key = edtKey.text.toString()
                val cache = AccountSecurity.getTimedCache<String>(key)
                txtValue.text = "${key}:${cache}"
            } else {
                requireContext().showToast("Cache key can not be empty")
            }
        }

        btnRemove.setOnClickListener {
            if (edtKey.text.isNullOrEmpty().not()) {
                val key = edtKey.text.toString()
                val cache = AccountSecurity.removeTimedCache<String>(key)
                txtValue.text = "${key}:${cache}"
            } else {
                requireContext().showToast("Cache key can not be empty")
            }
        }

        btnClearAll.setOnClickListener {
            AccountSecurity.clearTimedCaches()
            requireContext().showToast("Cleared all timed caches")
        }
    }

    companion object {
        fun newInstance() = TimedCacheReadFragment()
    }

}