package com.example.clinicaldatabase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.clinicaldatabase.databinding.ActivityMainBinding
import androidx.navigation.ui.NavigationUI.navigateUp as navigateUp1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerlayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerlayout = binding.drawerlayout


        val navcontroller = this.findNavController(R.id.MyNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navcontroller, drawerlayout)
        NavigationUI.setupWithNavController(binding.navView, navcontroller)
        navcontroller.addOnDestinationChangedListener{nc:NavController,nd:NavDestination,args:Bundle? ->
            if (nd.id==nc.graph.startDestination)
            {
                drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

            }
        else{
            drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

            }        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navcontroller = this.findNavController(R.id.MyNavHostFragment)
        return NavigationUI.navigateUp(navcontroller, drawerlayout)
    }

}