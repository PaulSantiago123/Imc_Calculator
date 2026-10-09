package com.example.imc.imcCalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.ui.text.font.FontWeight
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class imcCalculatorActivity : AppCompatActivity() {

    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView
    private lateinit var textHeight: TextView
    private lateinit var rangeSlider: RangeSlider
    private lateinit var weightMinusButton: FloatingActionButton
    private lateinit var weightPlusButton: FloatingActionButton
    private lateinit var numberWeight: TextView
    private lateinit var ageMinusButton: FloatingActionButton
    private lateinit var agePlusButton: FloatingActionButton
    private lateinit var numberAge: TextView

    private var maleSelected: Boolean = true
    private var femaleSelected: Boolean = false
    private var currentWeight: Int = 0
    private var currentAge: Int = 0


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
        initUI()

    }

    private fun initComponents() {
        cardMale = findViewById<CardView>(R.id.cardMale)
        cardFemale = findViewById<CardView>(R.id.cardFemale)
        textHeight = findViewById<TextView>(R.id.textHeight)
        rangeSlider = findViewById<RangeSlider>(R.id.rangeSlider)
        weightPlusButton = findViewById<FloatingActionButton>(R.id.weightPlusBtn)
        weightMinusButton = findViewById<FloatingActionButton>(R.id.weightMinusBtn)
        numberWeight = findViewById<TextView>(R.id.numberWeight)
        ageMinusButton = findViewById<FloatingActionButton>(R.id.ageMinusBtn)
        agePlusButton = findViewById<FloatingActionButton>(R.id.agePlusBtn)
        numberAge = findViewById<TextView>(R.id.numberAge)

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
            val decimal = DecimalFormat("#.##")
            val result = decimal.format(value)
            textHeight.text = "$result cm"
        }

        weightPlusButton.setOnClickListener {
            currentWeight++
            setWeight()
        }

        weightMinusButton.setOnClickListener {
            currentWeight--
            setWeight()
        }

        ageMinusButton.setOnClickListener {
            currentAge--
            setAge()

        }

        agePlusButton.setOnClickListener {
            currentAge++
            setAge()
        }
    }

    private fun setAge() {
        numberAge.text = currentAge.toString()
    }

    private fun setWeight() {
        numberWeight.text = currentWeight.toString()
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

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

}