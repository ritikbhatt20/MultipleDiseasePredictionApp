package com.example.multiplediseasepredictionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChooseDiseaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_disease)

        val diabetesBtn = findViewById<Button>(R.id.diabetesBtn)
        val heartBtn = findViewById<Button>(R.id.heartBtn)
        val parkBtn = findViewById<Button>(R.id.parkinsonBtn)

        diabetesBtn.setOnClickListener {
            val intent = Intent(this, DiabetesActivity::class.java)
            startActivity(intent)
        }

        heartBtn.setOnClickListener {
            val intent = Intent(this, HeartActivity::class.java)
            startActivity(intent)
        }

        parkBtn.setOnClickListener {
            val intent = Intent(this, ParkinsonActivity::class.java)
            startActivity(intent)
        }
    }
}