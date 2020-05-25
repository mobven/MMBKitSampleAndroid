package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.uicomponents.AddOnsActivity
import com.mobven.statemachine.binder.ItemBinder
import com.mobven.statemachine.model.StateMachineOption
import com.mobven.statemachine.view.StateMachineForm
import com.mobven.uicomponents.addons.attachMultiSelectPicker

class PickerInputBinder(private val context: Context, private val viewGroup: ViewGroup): ItemBinder<EditText>() {

    override fun bindPlaceholder(view: EditText, inputType: StateMachineForm.InputType, placeholder: String) {
        super.bindPlaceholder(view, inputType, placeholder)
        view.hint = placeholder
    }

    override fun getItem(inputType: StateMachineForm.InputType): EditText {
        return LayoutInflater.from(context).inflate(R.layout.item_picker, viewGroup, false) as EditText
    }

    override fun bindOptions(
        view: EditText,
        inputType: StateMachineForm.InputType,
        options: List<StateMachineOption>
    ) {
        val pickerItemList = options.map { option ->
            AddOnsActivity.MultiSelectItem(option.name!!)
        }

        view.attachMultiSelectPicker(
            pickerItemList, view.hint.toString()
        ) { }

    }

    override fun bindValueChangeListener(
        view: EditText,
        inputType: StateMachineForm.InputType,
        listener: (String) -> Unit
    ) {
        view.addTextChangedListener {
            listener(it.toString())
        }
    }
}