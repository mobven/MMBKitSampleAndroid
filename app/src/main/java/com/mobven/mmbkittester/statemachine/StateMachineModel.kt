package com.mobven.mmbkittester.statemachine

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.mobven.statemachine.model.StateMachineOption
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results (
    @SerializedName("objectId") val objectId : String?,
    @SerializedName("createdAt") val createdAt : String?,
    @SerializedName("updatedAt") val updatedAt : String?,
    @SerializedName("title") val title: String?,
    @SerializedName("fields") val fields: MutableList<Fields>?
) : Parcelable

data class Form (
    @SerializedName("results") val results : ArrayList<Results>?
)

@Parcelize
data class Fields (
    @SerializedName("id") val id : String?,
    @SerializedName("label") val label : String?,
    @SerializedName("placeholder") val placeholder : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("inputType") val inputType: String?,
    @SerializedName("value") val value : String?,
    @SerializedName("status") val status: Boolean?,
    @SerializedName("actionType") val actionType: String?,
    @SerializedName("rules") val rules : Rules?,
    @SerializedName("options") val options: MutableList<Option>?
) : Parcelable {
    fun toStateMachineOptionList(): MutableList<StateMachineOption>? =
        options?.map { it.toStateMachineOption() }?.toMutableList()
}

@Parcelize
data class Rules (
    @SerializedName("isRequired") val isRequired : Boolean?,
    @SerializedName("regex") val regex : String?,
    @SerializedName("message") val message : String?,
    @SerializedName("isRequired") val isRequired: Boolean?
) : Parcelable

@Parcelize
data class Option (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?
) : Parcelable {
    fun toStateMachineOption(): StateMachineOption = StateMachineOption(id, name)
}