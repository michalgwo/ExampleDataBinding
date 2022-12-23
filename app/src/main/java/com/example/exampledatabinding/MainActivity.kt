package com.example.exampledatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.exampledatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            binding.apply {
                if (editText.text.isBlank())
                    return@setOnClickListener

                examResult = getExamResult(editText.text.trim().toString())
                editText.text.clear()
            }
        }
    }

    private fun getExamResult(name: String): ExamResult {
        val maxPoints = 20
        return ExamResult(name, (0..maxPoints).random(), maxPoints)
    }
}