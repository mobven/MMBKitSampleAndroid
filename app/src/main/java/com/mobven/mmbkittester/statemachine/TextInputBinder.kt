package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.ItemBinder
import com.mobven.statemachine.view.StateMachineForm

class TextInputBinder(private val context: Context, private val viewGroup: ViewGroup): ItemBinder<TextInputLayout>() {

    override fun bindPlaceholder(view: TextInputLayout, inputType: StateMachineForm.InputType, placeholder: String) {
        super.bindPlaceholder(view, inputType, placeholder)
        view.hint = placeholder
    }

    override fun getItem(inputType: StateMachineForm.InputType): TextInputLayout {
        val view = LayoutInflater.from(context).inflate(R.layout.item_text_input_layout, viewGroup, false) as TextInputLayout
        val editText = view.findViewById<TextInputEditText>(R.id.input_edittext)
        if (inputType == StateMachineForm.InputType.EMAIL) {
            editText?.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        } else if (inputType == StateMachineForm.InputType.PASSWORD) {
            editText?.inputType = InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD or InputType.TYPE_CLASS_TEXT
        }
        return view
    }

}