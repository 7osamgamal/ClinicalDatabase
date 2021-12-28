package com.example.clinicaldatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities =[DentalDatabase::class],version = 1,exportSchema = false)
abstract class DataBase:RoomDatabase() {
    abstract val dentalDatabaseDao:DentalDatabaseDao
    companion object{
        @Volatile
        private var Instance:DataBase?=null
        fun getDatabase(context: Context):DataBase
        {
            synchronized(this)
            {
                var instance= Instance
                if (instance==null)
                {
                    instance=Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "Dental_Database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    Instance=instance
                }
                return Instance!!
            }
        }
    }

}