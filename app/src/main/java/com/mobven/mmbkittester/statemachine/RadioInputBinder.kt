package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.ItemBinder
import com.mobven.statemachine.model.StateMachineOption
import com.mobven.statemachine.view.StateMachineForm

class RadioInputBinder(private val context: Context, private val viewGroup: ViewGroup): ItemBinder<RadioGroup>() {

    override fun getItem(inputType: StateMachineForm.InputType): RadioGroup {
        val view = LayoutInflater.from(context).inflate(R.layout.item_radio_group, viewGroup, false) as RadioGroup
        return view
    }

    override fun bindOptions(
        view: RadioGroup,
        inputType: StateMachineForm.InputType,
        options: List<StateMachineOption>
    ) {
        val maleRadio = view.findViewById<RadioButton>(R.id.male_radio)
        val femaleRadio = view.findViewById<RadioButton>(R.id.female_radio)

        maleRadio.text = options[1].name
        femaleRadio.text = options[0].name
    }

    override fun bindValueChangeListener(
        view: RadioGroup,
        inputType: StateMachineForm.InputType,
        listener: (String) -> Unit
    ) {
        view.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadio = group.findViewById<RadioButton>(checkedId)
            listener(checkedRadio.text.toString())
        }
    }

}