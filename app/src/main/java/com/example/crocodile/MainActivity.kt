package com.example.crocodile

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.GravityCompat
import com.example.crocodile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Музыкальное сопровождение
        val mediaPlayer = MediaPlayer.create(this, R.raw.click2)
        val mediaPlayer2 = MediaPlayer.create(this, R.raw.music)

        //Подключение binding класса
        binding.apply {

            //Подключение кнопки таймера
            buttonStartTimer.setOnClickListener {
                playTimer()

                mediaPlayer.start()
            }

// Подключение кнопки для включение и выключения музыки
            buttonMusic.setOnClickListener {

                if (mediaPlayer2.isPlaying)

                    mediaPlayer2.pause();
                else

                    mediaPlayer2.start();
            }

//Подключение кнопки - "настройки"
            buttonSetting.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }

//Подключение меню навигации(Боковое меню)
            NavigationView.setNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.movie -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getMovie()
                            mediaPlayer.start()
                        }
                    }

                    R.id.carton -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getCartoon()
                            mediaPlayer.start()
                        }
                    }

                    R.id.work -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getWork()
                            mediaPlayer.start()
                        }
                    }

                    R.id.items -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getItems()
                            mediaPlayer.start()
                        }
                    }

                }
                drawer.closeDrawer(GravityCompat.START)
                true
            }
        }
    }

    //Основные функции, бокового меню

    private fun getItems(): String {
        return resources.getStringArray(R.array.item)[randomNumberItem()]
    }

    private fun randomNumberItem(): Int {
        val size = resources.getStringArray(R.array.item).size - 1
        return (0..size).random()
    }


    private fun getCartoon(): String {
        return resources.getStringArray(R.array.cartoon)[randomNumberCartoon()]
    }

    private fun randomNumberCartoon(): Int {
        val size = resources.getStringArray(R.array.cartoon).size - 1
        return (0..size).random()
    }

    private fun getMovie(): String {
        return resources.getStringArray(R.array.movie)[randomNumberMovie()]
    }

    private fun randomNumberMovie(): Int {
        val size = resources.getStringArray(R.array.movie).size - 1
        return (0..size).random()
    }

    private fun getWork(): String {
        return resources.getStringArray(R.array.work)[randomNumberWork()]
    }

    private fun randomNumberWork(): Int {
        val size = resources.getStringArray(R.array.work).size - 1
        return (0..size).random()
    }

    // функция таймер
    private fun playTimer() {
        object : CountDownTimer(30000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = "time: " + millisUntilFinished / 1000
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                binding.timer.text = ("done!")
            }
        }.start()
    }


}