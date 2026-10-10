package com.example.imc.imcCalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.R

class ResultActivity : AppCompatActivity() {
    private lateinit var textState: TextView
    private lateinit var IMC: TextView
    private lateinit var textDescription: TextView
    private lateinit var Recalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val result:Double = intent.extras?.getDouble("IMC_RESULT") ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initUI(result: Double) {
        IMC.text = result.toString()
        when (result) {
            in 0.00.. 18.50 -> {
                textState.text = getString(R.string.state_underweight)
                textState.setTextColor(ContextCompat.getColor(this, R.color.underweight))
                textDescription.text = getString(R.string.desc_underweight)
            }
            in 18.51.. 24.99 -> {
                textState.text = getString(R.string.state_normal_weight)
                textState.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                textDescription.text = getString(R.string.desc_normal_weight)
            }
            in 25.00.. 29.99 -> {
                textState.text = getString(R.string.state_overweight)
                textState.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                textDescription.text = getString(R.string.desc_overweight)
            }
            in 30.00.. 99.99 -> {
                textState.text = getString(R.string.state_obesity)
                textState.setTextColor(ContextCompat.getColor(this, R.color.obese))
                textDescription.text = getString(R.string.desc_obesity)
            }
            else -> {
                IMC.text = getString(R.string.error)
                textState.text = getString(R.string.error)
                textDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initListeners() {
        Recalculate.setOnClickListener { onBackPressed() }
    }

    private fun initComponents() {
        textState = findViewById<TextView>(R.id.textState)
        IMC = findViewById<TextView>(R.id.IMC)
        textDescription = findViewById<TextView>(R.id.textDescription)
        Recalculate = findViewById<Button>(R.id.btnRecalculate)
    }
}