package com.mobven.mmbkittester.statemachine

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.Gson
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.statemachine.AccountSelectionActivity.Companion.ACCOUNT_KEY
import com.mobven.statemachine.binder.ButtonBinder
import com.mobven.statemachine.binder.EditTextBinder
import com.mobven.statemachine.model.StateMachineItem
import com.mobven.statemachine.model.StateMachineRule
import com.mobven.statemachine.view.StateMachineForm
import kotlinx.android.synthetic.main.activity_state_machine_forms.*
import java.util.regex.Pattern

class StateMachineFormsActivity : AppCompatActivity() {

    private var accountSelectionBinder: AccountSelectionBinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_machine_forms)
        accountSelectionBinder = AccountSelectionBinder(this) {
            startActivityForResult(
                Intent(this, AccountSelectionActivity::class.java),
                REQUEST_CODE_ACCOUNT_SELECTION
            )
        }

        stateMachineForm.register(StateMachineForm.ItemType.TEXT, EditTextBinder(this))
        stateMachineForm.register(
            StateMachineForm.ItemType.TEXT,
            ID_ACCOUNT,
            accountSelectionBinder!!
        )
        stateMachineForm.register(StateMachineForm.ItemType.ACTION, ButtonBinder(this))
        stateMachineForm.feed(
            listOf(
                StateMachineItem(
                    ID_ACCOUNT, null, "Hesap Seç", "text", null, null, null, null,
                    StateMachineRule(true, Pattern.compile("[a-zA-Z0-9# ]+").pattern(), "Lütfen hesap seçin")
                ),
                StateMachineItem(
                    "mail", null, "e-mail", "text", null, null, null, null,
                    StateMachineRule(
                        true,
                        Patterns.EMAIL_ADDRESS.pattern(),
                        "Lütfen e-mail adresi girin"
                    )
                ),
                StateMachineItem(
                    "submit",
                    null,
                    null,
                    "action",
                    null,
                    "next",
                    "Next Page",
                    null,
                    null
                )
            )
        )
        stateMachineForm.errorListener = {
            MaterialAlertDialogBuilder(this).apply {
                setTitle("Hata")
                setMessage(it[0].message)
                setPositiveButton("OK") { _, _ -> }
                create().show()
            }
        }
        stateMachineForm.nextListener = { formData ->
            startActivity(Intent(this, StateMachineFormsSecondActivity::class.java).apply {
                putExtra("FORM_KEY", Gson().toJson(formData))
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ACCOUNT_SELECTION) {
            data?.extras?.getString(ACCOUNT_KEY)?.let {
                accountSelectionBinder?.valueChanged(it)
            }
        }
    }

    companion object {
        private const val ID_ACCOUNT = "account"
        private const val REQUEST_CODE_ACCOUNT_SELECTION = 1000
    }

}