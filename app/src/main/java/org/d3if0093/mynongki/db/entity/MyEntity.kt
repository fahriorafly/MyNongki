package org.d3if0093.mynongki.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "my_nongki")
data class MyEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var nameNongki: String,
    var addressNongki: String,
    var descNongki:String,
    var numNongki: String
): Parcelable