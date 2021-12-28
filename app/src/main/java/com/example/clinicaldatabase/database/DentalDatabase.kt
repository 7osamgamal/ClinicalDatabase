package com.example.clinicaldatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dental_Database_Table")
data class DentalDatabase(
    @PrimaryKey(autoGenerate = true)
    var patientId:Long=0L,
    @ColumnInfo(name = "patient_Name")
    var patientName:String="",
    @ColumnInfo(name = "patient_Age")
    var patientAge:String="",
    @ColumnInfo(name = "patient_Pain")
    var patientPain:String=""
)
