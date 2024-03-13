package com.example.basiccalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numInput1: EditText
    private lateinit var numInput2: EditText
    private lateinit var numOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        numInput1 = findViewById(R.id.numInput1)
        numInput2 = findViewById(R.id.numInput2)
        numOutput = findViewById(R.id.numOutput)

        val addButton: Button = findViewById(R.id.Add)
        val subButton: Button = findViewById(R.id.Sub)
        val multButton: Button = findViewById(R.id.Mult)
        val divButton: Button = findViewById(R.id.Div)

        addButton.setOnClickListener {
            calculate('+')
        }

        subButton.setOnClickListener {
            calculate('-')
        }

        multButton.setOnClickListener {
            calculate('*')
        }

        divButton.setOnClickListener {
            calculate('/')
        }

    }


    private fun calculate(operator: Char) {
        val num1 = numInput1.text.toString().toDouble()
        val num2 = numInput2.text.toString().toDouble()
        val result: Double = when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> if (num2 != 0.0) num1 / num2 else Double.NaN
            else -> Double.NaN
        }
        numOutput.setText(result.toString())
    }

}