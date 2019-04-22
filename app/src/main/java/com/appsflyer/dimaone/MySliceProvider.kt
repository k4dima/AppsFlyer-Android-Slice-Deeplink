package com.appsflyer.dimaone

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.SliceAction

class MySliceProvider : SliceProvider() {
    override fun onCreateSliceProvider() = true

    override fun onBindSlice(sliceUri: Uri): Slice? {
        val activityAction = SliceAction.create(
            PendingIntent.getActivity(
                context, 0, Intent(
                    Intent.ACTION_VIEW, Uri.parse(
                        "http://app.appsflyer.com/com.appsflyer.dimaone?pid=someMediaSource&c=someCampaign&" +
                                "af_dp=customscheme%3A%2F%2F"
                    )
                ), 0
            ),
            IconCompat.createWithResource(context, R.mipmap.appsflyer),
            ListBuilder.ICON_IMAGE,
            "Open App"
        )
        return ListBuilder(context, sliceUri, ListBuilder.INFINITY)
            .addRow(
                ListBuilder.RowBuilder()
                    .setTitle("Deeplink")
                    .setTitleItem(activityAction)
                    .setPrimaryAction(activityAction)
            )
            .build()
    }
}