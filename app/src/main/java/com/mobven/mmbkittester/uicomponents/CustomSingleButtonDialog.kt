package com.mobven.mmbkittester.uicomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.mobven.mmbkittester.R
import com.mobven.uicomponents.dialog.SingleButtonDialog

class CustomSingleButtonDialog(private val context: Context): SingleButtonDialog(context) {

    override val customLayout: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_custom_dialog, null)
    }

    init {
        singleButton.text = "OK"
        container.addView(customLayout)
        onSingleButtonClick {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

}