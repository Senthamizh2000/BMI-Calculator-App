package io.example.bmicalculatorapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.example.bmicalculatorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.text.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            calculateBMI()
        }

    }

    private fun calculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        if (weight != null && height != null) {
            val bmi = weight / (height/100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmiCategory = when {
                bmi < 18.5 -> "Under Weight"
                bmi < 25   -> "Normal"
                bmi < 30   -> "Over Weight"
                else -> "Obese"
            }
            binding.resultText.text = "BMI: $bmi \n Category: $bmiCategory"
        }
        else {
            binding.resultText.text = "Invalid Input"
        }
    }
}