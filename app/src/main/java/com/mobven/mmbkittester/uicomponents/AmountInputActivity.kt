package com.mobven.mmbkittester.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.uicomponents.amount.AmountInputView
import kotlinx.android.synthetic.main.activity_amount_input.*

class AmountInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amount_input)
        amountInput.setCurrencies(listOf(
            CurrencyData("EUR"),
            CurrencyData("USD"),
            CurrencyData("TRY")
        ))
        amountInput.selectCurrency(2)
        amountInput.setAmount(1000.0.toBigDecimal())
    }

    class CurrencyData(private val text: String) : AmountInputView.CurrencyItem {
        override fun textValue(): String = text
    }
}