package com.mobven.mmbkittester.statemachine

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mobven.mmbkittester.R
import com.mobven.statemachine.model.StateMachineItem
import com.mobven.statemachine.model.StateMachineRule
import com.mobven.statemachine.view.StateMachineForm
import kotlinx.android.synthetic.main.fragment_statemachine.*

class StateMachineFragment: Fragment() {

    companion object {

        private const val ARG_KEY_FORM_ITEMS = "form_items"
        private const val ARG_FORM_ID = "id"

        fun newInstance(items: ArrayList<Results>?, id: String?) = StateMachineFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_FORM_ID, id)
                putParcelableArrayList(ARG_KEY_FORM_ITEMS, items)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_statemachine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        state_machine.register(StateMachineForm.ItemType.TEXT, TextInputBinder(requireContext(), state_machine))
        state_machine.register(StateMachineForm.ItemType.ACTION, MaterialButtonBinder(requireContext(), state_machine))
        state_machine.register(StateMachineForm.ItemType.SELECT, PickerInputBinder(requireContext(), state_machine))
        state_machine.register(StateMachineForm.ItemType.RADIO, RadioInputBinder(requireContext(), state_machine))
        state_machine.register(StateMachineForm.ItemType.CHECKBOX, CheckboxInputBinder(requireContext(), state_machine))

        arguments?.getParcelableArrayList<Results>(ARG_KEY_FORM_ITEMS)?.let { arrayList ->
            val results = arrayList.filter { it.objectId == arguments?.getString(ARG_FORM_ID) }
            val stateMachineItemList: List<StateMachineItem>? = results[0].fields?.let { fieldsList ->
                fieldsList.map {fields ->
                    StateMachineItem(
                        fields.id,
                        fields.label,
                        fields.placeholder,
                        fields.type,
                        fields.inputType,
                        fields.actionType,
                        fields.value,
                        null,
                        StateMachineRule(fields.rules?.isRequired, fields.rules?.regex, fields.rules?.message),
                        fields.toStateMachineOptionList().orEmpty()
                    )
                }
            }

            stateMachineItemList?.let { list ->
                state_machine.feed(list)
            }

            state_machine.nextListener = { _ ->
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    add(R.id.frameContainer, newInstance(arrayList, "aG4OCBnq3A"))
                    addToBackStack(null)
                    commit()
                }
            }

            state_machine.requestListener = { _, _ ->
                Log.i("REQUEST", "REQ OK")
            }

            state_machine.errorListener = {
                Toast.makeText(requireContext(), it[0].message, Toast.LENGTH_SHORT).show()
            }

            state_machine.backListener = {

            }

        }
    }

}