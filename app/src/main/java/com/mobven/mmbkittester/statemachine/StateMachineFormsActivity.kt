package com.mobven.mmbkittester.statemachine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.EditTextBinder
import com.mobven.statemachine.model.StateMachineItem
import com.mobven.statemachine.view.StateMachineForm
import kotlinx.android.synthetic.main.activity_state_machine_forms.*

class StateMachineFormsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_machine_forms)
        stateMachineForm.setItemBinder(StateMachineForm.ItemType.TEXT, EditTextBinder(this))
        stateMachineForm.setData(listOf(
            StateMachineItem("1", null, "Hint1", "text", null, null, null),
            StateMachineItem("2", null, "Hint2", "text", "Value", null, null),
            StateMachineItem("3", null, "Hint3", "text", null, null, null)
        ))
    }

}