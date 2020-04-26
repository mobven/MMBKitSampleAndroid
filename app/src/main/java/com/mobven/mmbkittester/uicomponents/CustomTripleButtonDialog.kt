package com.mobven.mmbkittester.uicomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.mobven.mmbkittester.R
import com.mobven.uicomponents.dialog.TripleButtonDialog

class CustomTripleButtonDialog(private val context: Context): TripleButtonDialog(context) {

    override val customLayout: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_custom_dialog, null)
    }

    init {
        topButton.text = "OK"
        bottomButton.text = "Cancel"
        container.addView(customLayout)
        onMiddleButtonClick {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

}