package com.mobven.mmbkittester.appsecurity.securetext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.core.extension.isSecure
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_secure_text.*

class SecureTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secure_text)
        switchIsSecured.setOnCheckedChangeListener { _, isChecked ->
            edtSecure.isSecure(isChecked)
        }
    }
}