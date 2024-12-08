package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.URI

// Data class to represent a project asset
// using parcelize to put it as an extra in an intent
@Parcelize
data class Project(
    val id: Int,
    val title: String,
    var votes: Int,
    val assets: List<ProjectAsset>,
    val description: String,
    val groupMembers: List<Student>,
    val semester: Int
) : Parcelable
