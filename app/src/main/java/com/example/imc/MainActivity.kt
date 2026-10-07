package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.imc.imcCalculator.imcCalculatorActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView

    private var maleSelected: Boolean = true
    private var femaleSelected: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnImc = findViewById<Button>(R.id.btnImcCalculator)
        btnImc.setOnClickListener { navigateToImcCalculator() }
        initComponents()

    }

    private fun initComponents() {
        cardMale = findViewById<CardView>(R.id.cardMale)
        cardFemale = findViewById<CardView>(R.id.cardFemale)
    }

    private fun initListeners() {
        cardMale.setOnClickListener { setGenderColor(maleSelected) }
        cardFemale.setOnClickListener { setGenderColor(femaleSelected)  }
    }

    private fun navigateToImcCalculator() {
        val intent = Intent(this, imcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun setGenderColor(genderSelected: Boolean) {

    }


}

