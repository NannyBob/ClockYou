package com.bnyro.clock.obj

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timeZones")
data class TimeZone(
    @PrimaryKey val name: String,
    val displayName: String,
    val offset: Int,
    @ColumnInfo(defaultValue = "") val countryName: String = ""
)
