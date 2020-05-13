package com.mobven.mmbkittester.statemachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobven.mmbkittester.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateMachineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_machine)
        getForm(savedInstanceState)


    }

    private fun getForm(savedInstanceState: Bundle?) {
        RetrofitParseClient.create().buildForm().enqueue(object : Callback<Form> {
            override fun onFailure(call: Call<Form>, t: Throwable) {

            }

            override fun onResponse(call: Call<Form>, response: Response<Form>) {
                buildForm(response.body()?.results, savedInstanceState)
            }

        })
    }

    private fun buildForm(forms: ArrayList<Results>?, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                R.id.frameContainer, StateMachineFragment.newInstance(forms, "88o6S49W4k")
            ).commit()
        }
    }

}
