package com.gtech.covid_19app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_view_symptoms.*

class ViewSymptomsActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_symptoms)
        recylerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val symptomsList=ArrayList<symptomsModel>()

        symptomsList.add(symptomsModel(R.drawable.cough_symptoms,"Dry Cough","Dry coughs for 2-3 days"))
        symptomsList.add(symptomsModel(R.drawable.fever_symptoms,"Fever","Mild fever to Heavy fever"))
        symptomsList.add(symptomsModel(R.drawable.fatigue_symptoms,"Head Ache","headache may occur"))
        symptomsList.add(symptomsModel(R.drawable.tiredness_symptoms,"Tiredness","Body pain & Difficult to Breathe"))
        val symptomsAdapter=symptomsAdapter(symptomsList)

        recylerView.adapter=symptomsAdapter
       }
}
