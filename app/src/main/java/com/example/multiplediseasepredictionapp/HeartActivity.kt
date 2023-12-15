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

class HeartActivity : AppCompatActivity() {

    var url = "https://disease-prediction-g81g.onrender.com/predictH"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart)

        val age = findViewById<EditText>(R.id.ageInput)
        val sex = findViewById<EditText>(R.id.sexInput)
        val cp = findViewById<EditText>(R.id.cpInput)
        val trestbps = findViewById<EditText>(R.id.trestbpsInput)
        val chol = findViewById<EditText>(R.id.cholInput)
        val fbs = findViewById<EditText>(R.id.fbsInput)
        val restecg = findViewById<EditText>(R.id.restecgInput)
        val thalach = findViewById<EditText>(R.id.thalachInput)
        val exang = findViewById<EditText>(R.id.exangInput)
        val oldpeak = findViewById<EditText>(R.id.oldPeakInput)
        val slope = findViewById<EditText>(R.id.slopeInput)
        val ca = findViewById<EditText>(R.id.caInput)
        val thal = findViewById<EditText>(R.id.thalInput)

        val predictHeartBtn = findViewById<Button>(R.id.heartPredict)
        val result = findViewById<TextView>(R.id.result)
        val diabetesDiseaseBtn = findViewById<Button>(R.id.diabetesDiseaseButton)
        val parkinsonDiseaseBtn = findViewById<Button>(R.id.parkinsonDiseaseButton)


        predictHeartBtn.setOnClickListener {
            //hit the API -> Volley
            val stringRequest: StringRequest = object : StringRequest(
                Method.POST, url,
                Response.Listener { response ->
                    try {
                        val jsonObject = JSONObject(response)
                        val data = jsonObject.getString("Outcome of Heart")
                        if (data == "1") {
                            result.text = "Cardiac Patient"
                        } else {
                            result.text = "Heart is healthy"
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
                    params["age"] = age.text.toString()
                    params["sex"] = sex.text.toString()
                    params["cp"] = cp.text.toString()
                    params["trestbps"] = trestbps.text.toString()
                    params["chol"] = chol.text.toString()
                    params["fbs"] = fbs.text.toString()
                    params["restecg"] = restecg.text.toString()
                    params["thalach"] = thalach.text.toString()
                    params["exang"] = exang.text.toString()
                    params["oldpeak"] = oldpeak.text.toString()
                    params["slope"] = slope.text.toString()
                    params["ca"] = ca.text.toString()
                    params["thal"] = thal.text.toString()
                    return params
                }
            }
            val queue = Volley.newRequestQueue(this)
            queue.add(stringRequest)
        }

        diabetesDiseaseBtn.setOnClickListener {
            val intent = Intent(this, DiabetesActivity::class.java)
            startActivity(intent)
        }
        parkinsonDiseaseBtn.setOnClickListener {
            val intent = Intent(this, ParkinsonActivity::class.java)
            startActivity(intent)
        }
    }
}