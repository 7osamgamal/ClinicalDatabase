package com.example.clinicaldatabase.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicaldatabase.CellClickListener
import com.example.clinicaldatabase.database.DentalDatabase
import com.example.clinicaldatabase.databinding.RecyclermodelBinding

class RecyclerAdapter(var dentalClickListener: CellClickListener):ListAdapter<DentalDatabase,RecyclerAdapter.MyviewModel>(MyDiffUtill()) {
    class MyviewModel(val binding:  RecyclermodelBinding):RecyclerView.ViewHolder(binding.root){
        companion object{
            fun from(parent: ViewGroup):MyviewModel{
                val layoutinflater=LayoutInflater.from(parent.context)
                val binding=RecyclermodelBinding.inflate(layoutinflater,parent,false)
                return MyviewModel(binding)
            }
        }

        fun bind(item: DentalDatabase, dentalClickListener: CellClickListener) {
            binding.idtext.text=item.patientId.toString()
            binding.idname.text = item.patientName.toString()
            binding.idage.text = item.patientAge.toString()
            binding.idpain.text=item.patientPain.toString()
           // binding.clicklistener=dentalClickListener
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.MyviewModel {
        return MyviewModel.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.MyviewModel, position: Int) {
        val item=getItem(position)
        holder.bind(item,dentalClickListener)
        holder.itemView.setOnClickListener {
            dentalClickListener.onClickListener(item)
       }

    }
        class MyDiffUtill: DiffUtil.ItemCallback<DentalDatabase>() {
        override fun areItemsTheSame(oldItem: DentalDatabase, newItem: DentalDatabase): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: DentalDatabase, newItem: DentalDatabase): Boolean {
            return areItemsTheSame(oldItem,newItem)
        }

    }


}



