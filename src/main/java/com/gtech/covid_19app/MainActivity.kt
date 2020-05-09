package com.gtech.covid_19app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recylerViewSymptoms.layoutManager=LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val symptomsList=ArrayList<symptomsModel>()

        symptomsList.add(symptomsModel(R.drawable.cough_symptoms,"Dry Cough","Dry coughs for 2-3 days"))
        symptomsList.add(symptomsModel(R.drawable.fever_symptoms,"Fever","Mild fever to Heavy fever"))
        symptomsList.add(symptomsModel(R.drawable.fatigue_symptoms,"Head Ache","headache may occur"))
        symptomsList.add(symptomsModel(R.drawable.tiredness_symptoms,"Tiredness","Body pain & Difficult to Breathe"))
        val symptomsAdapter=symptomsAdapter(symptomsList)

        recylerViewSymptoms.adapter=symptomsAdapter
        getGlobalData()
        moreInfoBtn.setOnClickListener{
            var intent= Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)

        }

        txtViewSymptoms.setOnClickListener{
            var intent= Intent(this@MainActivity,ViewSymptomsActivity::class.java)
            startActivity(intent)

        }



    }
    fun getGlobalData(){
        val url:String="https://corona.lmao.ninja/v2/all/"
        val stringRequest=
            StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {
                var jsonObject=JSONObject(it.toString())
                txtInfected.text=jsonObject.getString("cases")
                txtRecovered.text=jsonObject.getString("recovered")
                txtDeceased.text=jsonObject.getString("deaths")



            },Response.ErrorListener {
                    Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_LONG).show()
                    txtInfected.text="-"
                    txtRecovered.text="-"
                    txtDeceased.text="-"

                }
        )
        val requestQueue=Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }
}
