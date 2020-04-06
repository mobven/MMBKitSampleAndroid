package com.mobven.mmbkittester.accountsecurity.timedcache

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import kotlinx.android.synthetic.main.fragment_timed_cache_write.*
import java.lang.NumberFormatException

class TimedCacheWriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_timed_cache_write, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnWrite.setOnClickListener {
            if (edtKey.text.isNullOrEmpty().not()) {
                if (edtValue.text.isNullOrEmpty().not()) {
                    if (edtDuration.text.isNullOrEmpty().not()) {
                        handleWrite(
                            edtKey.text.toString(),
                            edtValue.text.toString(),
                            edtDuration.text.toString()
                        )
                    } else {
                        requireContext().showToast("Cache duration can not be empty")
                    }
                } else {
                    requireContext().showToast("Cache value can not be empty")
                }
            } else {
                requireContext().showToast("Cache key can not be empty")
            }
        }
    }

    private fun handleWrite(key: String, value: String, duration: String) {
        try {
            AccountSecurity.putTimedCache(key, value, duration.toLong())
            requireContext().showToast("Wrote successfully")
        } catch (ignored: NumberFormatException) {
            requireContext().showToast("Duration value is not a long")
        }
    }

    companion object {
        fun newInstance() = TimedCacheWriteFragment()
    }

}