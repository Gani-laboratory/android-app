package com.reyuki.dicodingandroidapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize()
data class Article(
    val title: String,
    val content: String,
    val coverPhoto: Int
) : Parcelable
