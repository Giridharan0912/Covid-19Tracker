package com.gtech.covid_19app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_know_more.*

class KnowMoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_more)
        learnMoreBtn.setOnClickListener{
            var intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://covid19.who.int/"))
            startActivity(intent)
        }
    }
}
