package com.mobven.mmbkittester.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_custom_popup.*

class CustomPopupsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_popup)

        button_single.setOnClickListener {
            CustomSingleButtonDialog(this).create().show()
        }

        button_double.setOnClickListener {
            CustomDoubleButtonDialog(this).create().show()
        }

        button_triple.setOnClickListener {
            CustomTripleButtonDialog(this).create().show()
        }

        button_custom.setOnClickListener {
            CustomPopup(this).create().show()
        }
    }

}