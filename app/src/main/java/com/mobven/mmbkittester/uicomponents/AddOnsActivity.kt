package com.mobven.mmbkittester.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.uicomponents.addons.*
import kotlinx.android.synthetic.main.activity_add_ons.*
import java.util.*

class AddOnsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ons)

        val fourDp = resources.getDimension(R.dimen.space_small)
        val eightDp = resources.getDimension(R.dimen.space_medium)
        edt_shadow.putShadow(fourDp, fourDp.toInt(), 0.5f, eightDp)
        edt_custom.attachPickerListener {
            showToast("Your Custom Picker Here")
        }
        edt_multi_select.attachMultiSelectPicker(
            listOf(
                MultiSelectItem("Red"),
                MultiSelectItem("Green"),
                MultiSelectItem("Blue")
            ), "Select a Color"
        ) {
            showToast("Selected: ${it.textValue()}")
        }
        val dateCalendar = Calendar.getInstance()
        edt_date_picker.attachDatePicker(
            "dd/MM/yyyy",
            null,
            dateCalendar.get(Calendar.YEAR),
            dateCalendar.get(Calendar.MONTH),
            dateCalendar.get(Calendar.DAY_OF_MONTH),
            {
                //Configure date picker, set min/max selectable date etc.
            }, {
                showToast("Selected: $it")
            })
        val timeCalendar = Calendar.getInstance()
        edt_time_picker.attachTimePicker(
            "HH:mm",
            null,
            timeCalendar.get(Calendar.HOUR),
            timeCalendar.get(Calendar.MINUTE),
            true,
            {
                //Configure time picker, set min/max selectable hour etc.
            }, {
                showToast("Selected: $it")
            })
    }

    class MultiSelectItem(val text: String) : PickerItem {
        override fun textValue(): String = text
    }
}