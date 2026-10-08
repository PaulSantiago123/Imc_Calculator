package com.example.imc.imcCalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.R
import com.google.android.material.slider.RangeSlider

class imcCalculatorActivity : AppCompatActivity() {

    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView
    private lateinit var textHeight: TextView
    private lateinit var rangeSlider: RangeSlider

    private var maleSelected: Boolean = true
    private var femaleSelected: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()

    }

    private fun initComponents() {
        cardMale = findViewById<CardView>(R.id.cardMale)
        cardFemale = findViewById<CardView>(R.id.cardFemale)
        textHeight = findViewById<TextView>(R.id.textHeight)
        rangeSlider = findViewById<RangeSlider>(R.id.rangeSlider)
    }

    private fun initListeners() {
        cardMale.setOnClickListener {
            maleSelected = true
            femaleSelected = false
            setGenderColor()
        }
        cardFemale.setOnClickListener {
            maleSelected = false
            femaleSelected = true
            setGenderColor()
        }

        rangeSlider.addOnChangeListener { _, value, _ ->
            textHeight.text = value.toString()
        }
    }

    private fun setGenderColor() {
        cardMale.setBackgroundColor(getBackgroundColor(maleSelected))
        cardFemale.setBackgroundColor(getBackgroundColor(femaleSelected))
    }

    private fun getBackgroundColor(isSelected: Boolean): Int {
        val colorRes = if (isSelected) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorRes)
    }

}