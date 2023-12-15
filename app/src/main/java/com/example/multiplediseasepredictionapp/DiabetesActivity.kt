package com.example.multiplediseasepredictionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class DiabetesActivity : AppCompatActivity() {

    var url = "https://disease-prediction-g81g.onrender.com/predictD"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diabetes)

        val pregnancies = findViewById<EditText>(R.id.numberOfPregnanciesInput)
        val glucose = findViewById<EditText>(R.id.glucoseInput)
        val bloodPressure = findViewById<EditText>(R.id.bpValueInput)
        val skinThickness = findViewById<EditText>(R.id.skinThicknessInput)
        val insulin = findViewById<EditText>(R.id.insulinInput)
        val bmi = findViewById<EditText>(R.id.BMIInput)
        val diabetesPedigreeFunction = findViewById<EditText>(R.id.diabetesPedigreeInput)
        val age = findViewById<EditText>(R.id.ageInput)


        val predictDiabetesBtn = findViewById<Button>(R.id.diabetesPredict)
        val result = findViewById<TextView>(R.id.result)
        val heartDiseaseBtn = findViewById<Button>(R.id.heartDiseaseButton)
        val parkinsonDiseaseBtn = findViewById<Button>(R.id.parkinsonDiseaseButton)

        predictDiabetesBtn.setOnClickListener {
            //hit the API -> Volley
            val stringRequest: StringRequest = object : StringRequest(Method.POST, url,
                Response.Listener { response ->
                    try {
                        val jsonObject = JSONObject(response)
                        val data = jsonObject.getString("Outcome of Diabetes")
                        if (data == "1") {
                            result.text = "Person is Diabetic"
                        } else {
                            result.text = "Not Diabetic"
                        }
                    } catch (e: JSONException) {
                        throw RuntimeException(e)
                    }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }) {
                override fun getParams(): Map<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["Pregnancies"] = pregnancies.text.toString()
                    params["Glucose"] = glucose.text.toString()
                    params["BloodPressure"] = bloodPressure.text.toString()
                    params["SkinThickness"] = skinThickness.text.toString()
                    params["Insulin"] = insulin.text.toString()
                    params["BMI"] = bmi.text.toString()
                    params["DiabetesPedigreeFunction"] = diabetesPedigreeFunction.text.toString()
                    params["Age"] = age.text.toString()
                    return params
                }
            }
            val queue = Volley.newRequestQueue(this)
            queue.add(stringRequest)
        }

        heartDiseaseBtn.setOnClickListener {
            val intent = Intent(this, HeartActivity::class.java)
            startActivity(intent)
        }
        parkinsonDiseaseBtn.setOnClickListener {
            val intent = Intent(this, ParkinsonActivity::class.java)
            startActivity(intent)
        }

    }
}