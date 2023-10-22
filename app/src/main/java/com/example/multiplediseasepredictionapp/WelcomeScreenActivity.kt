package com.example.multiplediseasepredictionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val btn = findViewById<Button>(R.id.forwardBtn)
        btn.setOnClickListener {
            val intent = Intent(this, ChooseDiseaseActivity::class.java)
            startActivity(intent)
        }
    }
}