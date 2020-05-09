package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.textfield.TextInputLayout
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.ItemBinder

class TextInputBinder(private val context: Context, private val viewGroup: ViewGroup): ItemBinder<TextInputLayout>() {

    override fun getItem(): TextInputLayout =
        LayoutInflater.from(context).inflate(R.layout.item_text_input_layout, viewGroup, false) as TextInputLayout

    override fun bindPlaceholder(view: TextInputLayout, placeholder: String) {
        super.bindPlaceholder(view, placeholder)
        view.hint = placeholder
    }

}