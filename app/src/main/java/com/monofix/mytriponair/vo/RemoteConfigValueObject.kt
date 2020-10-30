package com.monofix.mytriponair.vo

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class BottomEventDataContainer (
    @SerializedName("bottom_event_datas")
    var bottomEventDatas: List<BottomEventData> = listOf()
)

data class BottomEventData (
    @SerializedName("bottom_event_code")
    val bottomEventCode: String,
    @SerializedName("bottom_event_name")
    val bottomEventName: String,
    @SerializedName("bottom_event_image_url")
    val bottomEventImageURL: String,
    @SerializedName("bottom_event_link")
    val bottomEventLink: String
)

fun BottomEventDataContainer.fromJson(json: String){
    val gson = Gson()
    this.bottomEventDatas = gson.fromJson(json, BottomEventDataContainer::class.java).bottomEventDatas
}