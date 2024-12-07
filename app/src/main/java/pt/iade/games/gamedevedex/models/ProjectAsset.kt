package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectAsset(
    val id: Int,
    val assetDescription: String,
    val assetResource: Int
) : Parcelable

