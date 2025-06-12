package org.l3on1kl.project.core.utils

import kotlinx.datetime.LocalDateTime

fun LocalDateTime.formatAsReadableString(): String {
    val day = if (dayOfMonth < 10) "0$dayOfMonth" else "$dayOfMonth"
    val month = if (monthNumber < 10) "0$monthNumber" else "$monthNumber"
    val hour = if (hour < 10) "0$hour" else "$hour"
    val minute = if (minute < 10) "0$minute" else "$minute"

    return "$day.$month.$year $hour:$minute"
}
