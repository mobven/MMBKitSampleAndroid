package com.mobven.mmbkittester.uicomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.mobven.mmbkittester.R
import com.mobven.uicomponents.dialog.DoubleButtonDialog

class CustomDoubleButtonDialog(private val context: Context): DoubleButtonDialog(context) {

    override val customLayout: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_custom_dialog, null)
    }

    init {
        leftButton.text = "OK"
        rightButton.text = "Cancel"
        container.addView(customLayout)
        onLeftButtonClick {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

}