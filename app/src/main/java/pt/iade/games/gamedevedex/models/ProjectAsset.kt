package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Data class to represent a project asset
// using parcelize to put it as an extra in an intent (it is used in the Projact Data class, therefore it needs to be parcelable as well)
@Parcelize
data class ProjectAsset(
    val id: Int,
    val assetDescription: String,
    val assetResource: Int
) : Parcelable

