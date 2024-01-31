package com.example.crocodile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.crocodile.databinding.ActivityMainMenuBinding


class MainMenu : AppCompatActivity() {
    private lateinit var binding: ActivityMainMenuBinding
    private var isVisibility = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            //Начинаем игру
            buttonStartGame.setOnClickListener {
                val start = Intent(this@MainMenu, MainActivity::class.java)
                startActivity(start)
            }
            //Читаем инструкцию
            buttonInstruction.setOnClickListener {
                if (!isVisibility) {
                    instruction.visibility = View.VISIBLE
                    buttonClose.visibility = View.VISIBLE
                    buttonInstruction.visibility = View.INVISIBLE
                    buttonExit.visibility = View.INVISIBLE
                    buttonStartGame.visibility = View.INVISIBLE
                }
            }
            //закрываем инструкцию
            buttonClose.setOnClickListener {
                if (!isVisibility) {
                    instruction.visibility = View.INVISIBLE
                    buttonClose.visibility = View.INVISIBLE
                    buttonInstruction.visibility = View.VISIBLE
                    buttonExit.visibility = View.VISIBLE
                    buttonStartGame.visibility = View.VISIBLE
                }
            }
            //выходим из игры
            buttonExit.setOnClickListener {
                finish()

            }
        }
    }
}