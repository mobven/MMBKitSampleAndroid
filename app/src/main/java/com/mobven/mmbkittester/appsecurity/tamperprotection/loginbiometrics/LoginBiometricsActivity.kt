package com.mobven.mmbkittester.appsecurity.tamperprotection.loginbiometrics

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.mmbkittester.R

class LoginBiometricsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_biometrics)
        biometricsTest()
    }

    private fun biometricsTest() {
        val account = "myUniqueAccount"
        val secondAccount = "mySecondAccount"
        //AccountSecurity.clearBiometricsKey(secondAccount)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AccountSecurity.authWithBiometrics(
                account,
                "Content locked",
                "Use your finger to unlock",
                "USE PASSWORD",
                {
                    Toast.makeText(this, it.type.name, Toast.LENGTH_SHORT).show()
                },
                {
                    Toast.makeText(this, "Auth successful", Toast.LENGTH_SHORT).show()
                },
                executorActivity = this
            )
        }
    }
}
