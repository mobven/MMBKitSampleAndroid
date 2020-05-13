package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import com.mobven.statemachine.binder.ItemBinder
import com.mobven.statemachine.view.StateMachineForm
import com.mobven.uicomponents.addons.attachPickerListener

class AccountSelectionBinder(
    private val context: Context,
    private val pickerListener: () -> Unit
) : ItemBinder<EditText>() {

    private var valueChangeListener: (String) -> Unit = {}
    private var selectionView: EditText? = null

    override fun getItem(inputType: StateMachineForm.InputType): EditText =
        EditText(context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            keyListener = null
        }

    override fun bindPlaceholder(
        view: EditText,
        inputType: StateMachineForm.InputType,
        placeholder: String
    ) {
        view.hint = placeholder
    }

    override fun bindValueChangeListener(
        view: EditText,
        inputType: StateMachineForm.InputType,
        listener: (String) -> Unit
    ) {
        valueChangeListener = listener
        selectionView = view
        view.attachPickerListener { pickerListener() }
    }

    fun valueChanged(value: String) {
        selectionView?.setText(value)
        valueChangeListener(value)
    }
}