package com.example.clinicaldatabase.patientdetails

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.clinicaldatabase.database.DentalDatabase
import com.example.clinicaldatabase.database.DentalDatabaseDao
import kotlinx.coroutines.*

class PatientDetailsViewmodel(val dentaldao: DentalDatabaseDao, application: Application) :
    AndroidViewModel(application) {

    private var viewmodeljob = Job()
    private var uiscope = CoroutineScope(Dispatchers.Main + viewmodeljob)
    var patientname = MutableLiveData<String>()
    var patientage = MutableLiveData<String>()
    var patientpain = MutableLiveData<String>()
    var allpatient = dentaldao.getallpatient()
    fun onsave() {
        val name=patientname.value!!
        val age=patientage.value!!
        val pain=patientpain.value!!

        uiscope.launch {
            insert(DentalDatabase(0,name,age,pain))
            patientname.value=null
            patientage.value=null
            patientpain.value=null
        }
    }

    private suspend fun insert(patient: DentalDatabase) {
        withContext(Dispatchers.IO) {
            dentaldao.inser(patient)

        }
    }


}