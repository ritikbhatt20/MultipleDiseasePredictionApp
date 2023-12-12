package com.example.multiplediseasepredictionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DiabetesActivity : AppCompatActivity() {

    var url = "https://disease-prediction-g81g.onrender.com/predictD"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diabetes)

        val cgpa = findViewById<EditText>(R.id.cgpa)
        val iq = findViewById<EditText>(R.id.iq)
        val profile_score = findViewById<EditText>(R.id.profileScore)
        val predict = findViewById<Button>(R.id.btn)
        val result = findViewById<TextView>(R.id.result)

    }
}