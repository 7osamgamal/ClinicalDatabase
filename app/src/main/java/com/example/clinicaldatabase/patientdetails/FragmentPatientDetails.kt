package com.example.clinicaldatabase.patientdetails

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.clinicaldatabase.R
import com.example.clinicaldatabase.database.DataBase
import com.example.clinicaldatabase.databinding.FragmentPatientDetailsBinding


open class FragmentPatientDetails : Fragment() {

    private lateinit var binding: FragmentPatientDetailsBinding
    lateinit var ViewModelFactory: PatientDetailsViewmodelFactory
    lateinit var viewmodel: PatientDetailsViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            inflate(inflater, R.layout.fragment_patient_details, container, false)
        val applicatio = requireNotNull(this.activity).application
        val Dao = DataBase.getDatabase(applicatio).dentalDatabaseDao
        binding.lifecycleOwner = this

        ViewModelFactory = PatientDetailsViewmodelFactory(Dao, applicatio)
        viewmodel =
            ViewModelProvider(this, ViewModelFactory).get(PatientDetailsViewmodel::class.java)
        binding.dentalviewmodel = viewmodel
        binding.btnshow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragmentPatientDetails_to_fragmentDatabaseShow)
        }

        return binding.root
    }




}