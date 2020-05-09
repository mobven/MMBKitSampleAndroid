package com.mobven.mmbkittester.statemachine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.mobven.mmbkittester.R
import com.mobven.statemachine.binder.ItemBinder

class MaterialButtonBinder(private val context: Context, private val viewGroup: ViewGroup): ItemBinder<MaterialButton>() {

    override fun getItem(): MaterialButton =
        LayoutInflater.from(context).inflate(R.layout.item_material_button, viewGroup, false) as MaterialButton

    override fun bindValue(view: MaterialButton, value: String) {
        super.bindValue(view, value)
        view.text = value
    }

}