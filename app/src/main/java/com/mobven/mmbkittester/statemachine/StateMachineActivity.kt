package com.mobven.mmbkittester.statemachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobven.mmbkittester.R
import com.mobven.statemachine.model.StateMachineItem
import com.mobven.statemachine.model.StateMachineRule
import com.mobven.statemachine.view.StateMachineForm
import kotlinx.android.synthetic.main.activity_state_machine.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateMachineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_machine)
        getForm()

        btn_update.setOnClickListener { getForm() }
    }

    private fun getForm() {
        RetrofitParseClient.create().buildForm().enqueue(object : Callback<Form> {
            override fun onFailure(call: Call<Form>, t: Throwable) {

            }

            override fun onResponse(call: Call<Form>, response: Response<Form>) {
                val results = response.body()?.results?.filter { it.objectId == "88o6S49W4k" }
                buildForm(results?.get(0)?.fields)
            }

        })
    }

    private fun buildForm(fields: List<Fields>?) {
        state_machine.setItemBinder(StateMachineForm.ItemType.TEXT, TextInputBinder(this, state_machine))
        state_machine.setItemBinder(StateMachineForm.ItemType.ACTION, MaterialButtonBinder(this, state_machine))

        val stateMachineItemList: List<StateMachineItem>? = fields?.let {
            it.map {fields ->
                StateMachineItem(
                    fields.id,
                    fields.label,
                    fields.placeholder,
                    fields.type,
                    null,
                    fields.value,
                    null,
                    StateMachineRule(fields.rules?.regex, fields.rules?.message))
            }
        }

        stateMachineItemList?.let {
            state_machine.setData(it)
        }
    }

}
