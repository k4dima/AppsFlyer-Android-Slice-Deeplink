package com.appsflyer.dimaone

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.appsflyer.dimaone.BuildConfig.APPLICATION_ID
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeeplinkTest {
    @Test
    fun test() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("slice-content://com.appsflyer.dimaone/"))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
        context.startActivity(intent)
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val slice = device.findObject(UiSelector().text("Deeplink"))
        slice.click()
        val text = device.findObject(By.res(APPLICATION_ID, "text"))
        Assert.assertTrue(
            text.text == "customscheme://?af_deeplink=true&campaign=someCampaign&media_source=someMediaSource"
        )
    }
}
