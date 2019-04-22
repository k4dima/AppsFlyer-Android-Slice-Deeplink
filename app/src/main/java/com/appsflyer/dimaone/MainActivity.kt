package com.appsflyer.dimaone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        @Suppress("SpellCheckingInspection")
        AppsFlyerLib.getInstance().startTracking(application, "fhXj93vYUC2beX4a8mQode")
        val deeplink = intent.data?.toString()
        println(deeplink)
        text.text = deeplink
    }
}