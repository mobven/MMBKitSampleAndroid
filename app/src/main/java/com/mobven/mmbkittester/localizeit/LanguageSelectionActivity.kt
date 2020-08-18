package com.mobven.mmbkittester.localizeit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.gson.JsonArray
import com.mobven.localizeit.LocalizeIt
import com.mobven.localizeit.setLocalizedText
import com.mobven.mmbkittester.MobKitApp.Companion.LANGUAGE_ENGLISH
import com.mobven.mmbkittester.MobKitApp.Companion.LANGUAGE_TURKISH
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import kotlinx.android.synthetic.main.activity_language_selection.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LanguageSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_selection)
        when (LocalizeIt.selectedLanguage.value) {
            LANGUAGE_ENGLISH -> rdEnglish.isChecked = true
            LANGUAGE_TURKISH -> rdTurkish.isChecked = true
        }
        rdEnglish.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                LocalizeIt.changeLanguage(LANGUAGE_ENGLISH)
            }
        }
        rdTurkish.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                LocalizeIt.changeLanguage(LANGUAGE_TURKISH)
            }
        }
        RetrofitTypicodeClient.create().getTags().enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                showToast(LocalizeIt.getString("network_error"))
            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                response.body()?.let {
                    LocalizeIt.appendStringsJson(it)
                    LocalizeIt.selectedLanguage.observe(this@LanguageSelectionActivity, Observer {
                        title = LocalizeIt.getString("language_selection")
                        rdEnglish.setLocalizedText("english")
                        rdTurkish.setLocalizedText("turkish")
                    })
                }
            }
        })
    }
}