package com.example.mandiri_news_apps.helper

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object formatDate {
    fun fromIso(isoDate: String?): String {
        if (isoDate.isNullOrEmpty()) return ""

        return try {
            val parser = SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'",
                Locale.US
            )
            parser.timeZone = TimeZone.getTimeZone("UTC")

            val formatter = SimpleDateFormat(
                "dd MMM yyyy",
                Locale("id")
            )

            formatter.format(parser.parse(isoDate)!!)
        } catch (e: Exception) {
            ""
        }
    }
}
