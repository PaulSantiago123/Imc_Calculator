package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.imc.imcCalculator.imcCalculatorActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnImc = findViewById<Button>(R.id.btnImcCalculator)
        btnImc.setOnClickListener { navigateToImcCalculator() }

    }



    private fun navigateToImcCalculator() {
        val intent = Intent(this, imcCalculatorActivity::class.java)
        startActivity(intent)
    }



}

