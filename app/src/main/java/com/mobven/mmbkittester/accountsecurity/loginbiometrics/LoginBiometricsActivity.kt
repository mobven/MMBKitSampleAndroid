package com.mobven.mmbkittester.accountsecurity.loginbiometrics

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_login_biometrics.*

class LoginBiometricsActivity : AppCompatActivity() {

    private val accountKey = "myUniqueAccount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_biometrics)

        btnLogin.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                AccountSecurity.authWithBiometrics(
                    accountKey,
                    "Content locked",
                    "Use biometric login to unlock",
                    "USE PASSWORD",
                    {
                        Toast.makeText(this, it.type.name, Toast.LENGTH_SHORT).show()
                    },
                    {
                        txtValue.text = it
                    },
                    executorActivity = this
                )
            }
        }

        btnClear.setOnClickListener {
            AccountSecurity.clearBiometricsKey(accountKey)
            txtValue.text = ""
        }
    }
}
