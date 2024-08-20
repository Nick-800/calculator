package com.example.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var opernum1: Double = 0.0
    private var opernum2: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding

        val buttons = listOf(
            binding.button0, binding.button1, binding.button2, binding.button3, binding.button4,
            binding.button5, binding.button6, binding.button7, binding.button8, binding.button9,
            binding.buttonAdd, binding.buttonSubtract, binding.buttonMultiply, binding.buttonDivide,
            binding.buttonEquals, binding.buttonClear
        )

        buttons.forEach { button ->
            button.setOnClickListener { onButtonClick(it as Button) }
        }
    }

    private fun onButtonClick(button: Button) {
        when (button) {
            binding.buttonClear -> {
                binding.resultTextView.text = ""
                opernum1 = 0.0
                opernum2 = 0.0
                operation = ""
            }
            binding.buttonEquals -> {
                opernum2 = binding.resultTextView.text.toString().toDouble()
                val result = when (operation) {
                    "+" -> opernum1 + opernum2
                    "-" -> opernum1 - opernum2
                    "*" -> opernum1 * opernum2
                    "/" -> opernum1 / opernum2
                    else -> 0.0
                }
                binding.resultTextView.text = result.toString()
            }
            binding.buttonAdd, binding.buttonSubtract, binding.buttonMultiply, binding.buttonDivide -> {
                opernum1 = binding.resultTextView.text.toString().toDouble()
                operation = button.text.toString()
                binding.resultTextView.text = ""
            }
            else -> {
                binding.resultTextView.append(button.text)
            }
        }
    }
}
