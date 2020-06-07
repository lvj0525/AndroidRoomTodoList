package com.wechats.roomtodolist.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Todo (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val content: String
) : Parcelable