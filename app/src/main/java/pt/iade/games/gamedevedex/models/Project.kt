package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.URI

@Parcelize
data class Project(
    val id: Int,
    val title: String,
    var votes: Int,
    val assets: List<URI>,
    val description: String,
    val groupMembers: List<Student>,
    val semester: Int
) : Parcelable
