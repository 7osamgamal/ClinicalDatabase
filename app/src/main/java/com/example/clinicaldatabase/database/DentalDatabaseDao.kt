package com.example.clinicaldatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DentalDatabaseDao {
   @Insert
    fun inser(dentaldatabase:DentalDatabase)
    @Query("DELETE FROM Dental_Database_Table")
    fun delete()
    @Query("SELECT* FROM Dental_Database_Table ORDER BY patientId DESC")
    fun getallpatient():LiveData<List<DentalDatabase>>
    @Update
    fun updateage(age:DentalDatabase)
}