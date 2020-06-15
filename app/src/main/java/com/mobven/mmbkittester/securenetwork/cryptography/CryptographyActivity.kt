package com.mobven.mmbkittester.securenetwork.cryptography

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.core.extension.decodeFromBase64
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.network.SecureNetwork
import kotlinx.android.synthetic.main.activity_cryptography.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.NumberFormatException

class CryptographyActivity : AppCompatActivity() {

    private lateinit var cryptoApi: CryptoApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptography)
        
        with(SecureNetwork) {
            isDebug = true
            enableCryptography(
                "https://capture.mobven.com/crypt/rsa/validData.php",
                ("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCyLNbf8jtBlVTGjJZmiRzRhO1y" +
                        "bGKlZpvaL5VbBFTJCKypyc7kpTtOuXRgCY+jYbZ4+OKHicvy9pE8qSqSzFOxXmGK" +
                        "00gziT+8lc0fpk8SLFeE/H1RF+qjh1k4zmqmSRe576bcLGRAJW0NtSWS+/+VwQFy" +
                        "yUjRM67OjCh4huRaGwIDAQAB").decodeFromBase64()
            )
            cryptoApi = createCryptoAPI(
                "https://capture.mobven.com/crypt/",
                CryptoApi::class.java,
                retrofitConfigCallback = {
                    it.addConverterFactory(GsonConverterFactory.create())
                })
        }


        btnInitRSA.setOnClickListener {
            SecureNetwork.handshake { isSuccess, error ->
                if (isSuccess) {
                    showToast("init success")
                } else {
                    showToast("init failure: ${error?.message}")
                }
            }
        }

        btnGetNumbers.setOnClickListener {
            try {
                val count = edtCount.text.toString().toInt()
                cryptoApi.getNumbers(CryptoRequest(count))
                    .enqueue(object : Callback<CryptoResponse> {
                        override fun onFailure(call: Call<CryptoResponse>, t: Throwable) {
                            showToast("Failure: ${t.message}")
                        }

                        override fun onResponse(
                            call: Call<CryptoResponse>,
                            response: Response<CryptoResponse>
                        ) {
                            showToast(response.body()?.numbers?.joinToString())
                        }

                    })
            } catch (ex: NumberFormatException) {
                showToast("Please enter a number")
            }
        }
    }

}