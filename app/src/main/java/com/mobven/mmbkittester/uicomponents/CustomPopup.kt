package com.mobven.mmbkittester.uicomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobven.mmbkittester.R
import com.mobven.uicomponents.dialog.BaseDialog

class CustomPopup(context: Context): BaseDialog() {

    override val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_fully_custom_dialog, null)
    }

    override val builder: MaterialAlertDialogBuilder =
        MaterialAlertDialogBuilder(context, R.style.Theme_MaterialComponents_Light_Dialog_Alert).setView(dialogView)
}