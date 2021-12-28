package com.example.clinicaldatabase.patientdetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clinicaldatabase.database.DentalDatabase
import com.example.clinicaldatabase.database.DentalDatabaseDao

class PatientDetailsViewmodelFactory(private var dentaldao:DentalDatabaseDao,private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PatientDetailsViewmodel::class.java)) {
            return PatientDetailsViewmodel(dentaldao,application) as T
        }
        throw IllegalArgumentException("no view model created")
    }


}