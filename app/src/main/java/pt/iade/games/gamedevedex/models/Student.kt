package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.URI

// Data class to represent a student
// using parcelize to put it as an extra in an intent (it is used in the Projact Data class, therefore it needs to be parcelable as well)
@Parcelize
data class Student(
    val id: Int,
    val name: String,
    val avatar: Int,
    val biography: String,
    val mood: MoodEnum
):Parcelable
