package com.gtech.covid_19app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class symptomsAdapter(var symptomList:ArrayList<symptomsModel>):RecyclerView.Adapter<symptomsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): symptomsAdapter.ViewHolder {
val inflater=LayoutInflater.from(parent.context)
        return ViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
       return symptomList.size
    }

    override fun onBindViewHolder(holder: symptomsAdapter.ViewHolder, position: Int) {
        val symptomsModel=symptomList[position]
        holder.bind(symptomsModel)

    }
    class ViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup):RecyclerView.ViewHolder(inflater.inflate(R.layout.items_symptoms,viewGroup,false)){


        fun bind(symptomsModel: symptomsModel){
            val symptomsText = itemView.findViewById<TextView>(R.id.txtSymptoms)
            val symptomsTextDetails=itemView.findViewById<TextView>(R.id.txtSymptomsdetails)
            val symptomsImageView=itemView.findViewById<ImageView>(R.id.imgSymptoms)
            symptomsText.text= symptomsModel.symptomText
            symptomsTextDetails.text=symptomsModel.symptomDetail
            symptomsImageView.setImageResource(symptomsModel.imageView)
        }
    }
}