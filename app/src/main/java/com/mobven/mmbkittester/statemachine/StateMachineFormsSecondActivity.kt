package com.mobven.mmbkittester.statemachine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.ButtonBinder
import com.mobven.statemachine.binder.EditTextBinder
import com.mobven.statemachine.model.StateMachineItem
import com.mobven.statemachine.model.StateMachinePage
import com.mobven.statemachine.view.StateMachineForm
import kotlinx.android.synthetic.main.activity_state_machine_forms_second.*

class StateMachineFormsSecondActivity : AppCompatActivity() {

    private val formDataToken = object : TypeToken<List<StateMachinePage>>() {}.type

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_machine_forms_second)
        val oldData: JsonArray =
            Gson().fromJson(intent.getStringExtra("FORM_KEY"), JsonArray::class.java)
        stateMachineForm.oldFormsData = oldData
        stateMachineForm.setItemBinder(StateMachineForm.ItemType.TEXT, EditTextBinder(this))
        stateMachineForm.setItemBinder(StateMachineForm.ItemType.ACTION, ButtonBinder(this))
/*        stateMachineForm.setData(
            listOf(
                StateMachineItem("1", null, "Hint1", "text", null, null, null, null),
                StateMachineItem("2", null, "Hint2", "text", "Value", null, null, null),
                StateMachineItem("3", null, "Hint3", "text", null, null, null, null),
                StateMachineItem("4", null, null, "action", "request", "Submit", null, null)
            )
        )*/
        stateMachineForm.requestListener = { _, formData ->
            MaterialAlertDialogBuilder(this).apply {
                setTitle("Final Data")
                val messageBuilder = StringBuilder()
                val gson = Gson()
                val formJson = gson.toJson(formData)
                val pages = gson.fromJson<List<StateMachinePage>>(formJson, formDataToken)
                pages.forEachIndexed { index, page ->
                    messageBuilder.append("$index:\n")
                    page.fields.forEach {
                        messageBuilder.append(
                            "\tid:${it.id} value:${it.value} \n"
                        )
                    }
                }
                setMessage(messageBuilder.toString())
                setPositiveButton("OK") { _, _ -> }
                create().show()
            }
        }
    }

}