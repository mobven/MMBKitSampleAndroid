package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.ItemBinder
import com.mobven.statemachine.view.StateMachineForm

class MaterialButtonBinder(private val context: Context, private val viewGroup: ViewGroup): ItemBinder<MaterialButton>() {

    override fun bindValue(view: MaterialButton, inputType: StateMachineForm.InputType, value: String) {
        super.bindValue(view, inputType, value)
        view.text = value
    }

    override fun getItem(inputType: StateMachineForm.InputType): MaterialButton =
        LayoutInflater.from(context).inflate(R.layout.item_material_button, viewGroup, false) as MaterialButton

    override fun bindActionPerformedListener(
        view: MaterialButton,
        inputType: StateMachineForm.InputType,
        listener: () -> Unit
    ) {
        view.setOnClickListener {
            listener()
        }
    }

}