package com.example.crocodile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.crocodile.databinding.ActivityGameBinding

class ActivityGame : AppCompatActivity() {
lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGameBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply{
buttonNext.setOnClickListener{
    textStart.text = getMovie()
}

        }
    }


    private fun getMovie(): String {
        return resources.getStringArray(R.array.work)[randomNumberMovie()]
    }

    private fun randomNumberMovie(): Int {
        val size = resources.getStringArray(R.array.work).size - 1
        return (0..size).random()
    }

    fun back(view: View) {
        val back = Intent(this, MainActivity::class.java)
        startActivity(back)
    }
}