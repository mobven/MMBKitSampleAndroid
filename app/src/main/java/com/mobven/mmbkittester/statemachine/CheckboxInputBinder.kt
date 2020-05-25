package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.checkbox.MaterialCheckBox
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.ItemBinder
import com.mobven.statemachine.model.StateMachineOption
import com.mobven.statemachine.view.StateMachineForm

class CheckboxInputBinder(private val context: Context, private val viewGroup: ViewGroup): ItemBinder<MaterialCheckBox>() {

    override fun getItem(inputType: StateMachineForm.InputType): MaterialCheckBox {
        return LayoutInflater.from(context).inflate(R.layout.item_checkbox, viewGroup, false) as MaterialCheckBox
    }

    override fun bindLabel(
        view: MaterialCheckBox,
        inputType: StateMachineForm.InputType,
        label: String
    ) {
        view.text = label
    }

    override fun bindStatusChangeListener(
        view: MaterialCheckBox,
        inputType: StateMachineForm.InputType,
        listener: (Boolean) -> Unit
    ) {
        view.setOnCheckedChangeListener { _ , isChecked ->
            listener(isChecked)
        }
    }

}