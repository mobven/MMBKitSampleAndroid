package com.mobven.mmbkittester.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_key_value_list.*

class KeyValueListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_value_list)

        kv_label_list.values = listOf(
            "Key1" to "Value1",
            "Key2" to "Value2",
            "Key3" to "Value3",
            "Key4" to "Value4",
            "Key5" to "Value5",
            "Key6" to "Value6"
        )
    }

}