package com.monofix.mytriponair.utils

import java.text.SimpleDateFormat
import java.util.*

const val EVENT_KEY_DATE_TODAY = "EVENT_REMEMBER_TODAY"
const val ADS_KEY_DATE_TODAY = "ADS_REMEMBER_TODAY"

fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("dd-MM-yyyy")
    return sdf.format(Date())
}
