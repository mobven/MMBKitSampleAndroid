package com.mobven.mmbkittester.statemachine

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_account_selection.*

class AccountSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_selection)
        accountFirst.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().putExtra(ACCOUNT_KEY, txtId.text))
            finish()
        }
        accountSecond.setOnClickListener {
            setResult(
                Activity.RESULT_OK,
                Intent().putExtra(ACCOUNT_KEY, txtIdSecond.text.toString())
            )
            finish()
        }
        accountThird.setOnClickListener {
            setResult(
                Activity.RESULT_OK,
                Intent().putExtra(ACCOUNT_KEY, txtIdThird.text.toString())
            )
            finish()
        }
    }

    companion object {
        const val ACCOUNT_KEY = "account"
    }

}