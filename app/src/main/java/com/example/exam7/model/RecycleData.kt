package com.example.exam7.model

import com.squareup.moshi.Json

data class RecycleData(
    @Json(name = "active_courses")
    val activeCourses: List<ActiveCourse>,
    @Json(name = "new_courses")
    val newCourses: List<NewCourse>
) {
    data class ActiveCourse (
        @Json(name = "background_color_percent")
        val backgroundColorPercent: String?,
        @Json(name = "booking_time")
        val bookingTime: String?,
        val id: String?,
        val image: String?,
        @Json(name = "main_color")
        val mainColor: String?,
        @Json(name = "play_button_color_percent")
        val playButtonColorPercent: String?,
        val progress: String?,
        val title: String?
    )

    data class NewCourse (
        val duration: String?,
        @Json(name = "icon_type")
        val iconType: String?,
        val id: String?,
        @Json(name = "main_color")
        val mainColor: String?,
        val question: String?,
        val title: String?
    )
}