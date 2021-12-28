package com.example.clinicaldatabase.databaseshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clinicaldatabase.CellClickListener
import com.example.clinicaldatabase.R
import com.example.clinicaldatabase.database.DataBase
import com.example.clinicaldatabase.database.DentalDatabase
import com.example.clinicaldatabase.databinding.FragmentDatabaseShowBinding
import com.example.clinicaldatabase.patientdetails.FragmentPatientDetails
import com.example.clinicaldatabase.patientdetails.PatientDetailsViewmodel
import com.example.clinicaldatabase.patientdetails.PatientDetailsViewmodelFactory


import com.example.clinicaldatabase.recycleradapter.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_database_show.*

open class FragmentDatabaseShow : FragmentPatientDetails(),CellClickListener {
    val adapter=RecyclerAdapter(this)
private lateinit var binding: FragmentDatabaseShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_database_show, container, false)
        val applicatio = requireNotNull(this.activity).application
        val Dao = DataBase.getDatabase(applicatio).dentalDatabaseDao

        binding.lifecycleOwner = this
        binding.recyclerview.setHasFixedSize(true)

        binding.recyclerview.adapter=adapter
        binding.executePendingBindings()


        ViewModelFactory = PatientDetailsViewmodelFactory(Dao, applicatio)
        viewmodel =
            ViewModelProvider(this, ViewModelFactory).get(PatientDetailsViewmodel::class.java)
       show()

        return binding.root

    }
    fun show(){
        viewmodel.allpatient.observe(viewLifecycleOwner, Observer {
          adapter.submitList(it)
        })
    }

    override fun onClickListener(data: DentalDatabase) {
        //Toast.makeText(activity, "${data.patientName}", Toast.LENGTH_SHORT).show()
        data.patientAge="10"
    }


}