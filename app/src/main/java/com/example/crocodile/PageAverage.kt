package com.example.crocodile


import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.GravityCompat

import com.example.crocodile.databinding.ActivityPageAverageBinding

class PageAverage : AppCompatActivity() {
    lateinit var binding: ActivityPageAverageBinding
    private var isPlaying = false
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPageAverageBinding.inflate(layoutInflater)
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

            //// Подключение кнопки для включение и выключения музыки
            buttonMusic.setOnClickListener {

                if (!isPlaying) {

                    isPlaying = true
                    buttonMusic.setImageResource(R.drawable.music_on)
                    mediaPlayer2.start();
                } else {

                    isPlaying = false
                    buttonMusic.setImageResource(R.drawable.music_off)
                    mediaPlayer2.pause();
                }
            }
            //Подключение кнопки - "настройки"
            buttonSetting.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
            //Average

            NavigationView.setNavigationItemSelectedListener {
//Выбор Сложности
                when (it.itemId) {
                    R.id.easy -> {
                        val intent = Intent(this@PageAverage, MainActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.hard -> {
                        val intent = Intent(this@PageAverage, PageHard::class.java)
                        startActivity(intent)
                    }
//
                    R.id.movie -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getMovieAverage()
                            mediaPlayer.start()
                        }
                    }

                    R.id.carton -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getCartoonAverage()
                            mediaPlayer.start()
                        }
                    }

                    R.id.work -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getWorkAverage()
                            mediaPlayer.start()
                        }
                    }

                    R.id.items -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getItemsAverage()
                            mediaPlayer.start()
                        }
                    }

                }
                drawer.closeDrawer(GravityCompat.START)
                true
            }
        }
    }


    //
//

    // функция таймер
    private fun playTimer() {
        object : CountDownTimer(100000, 1000) {


            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = "time: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                binding.timer.text = ("done!")
            }
        }.start()
    }
//    //Средний уровень функции

    private fun getItemsAverage(): String {
        return resources.getStringArray(R.array.itemAverage)[randomNumberItemAverage()]
    }

    private fun randomNumberItemAverage(): Int {
        val size = resources.getStringArray(R.array.itemAverage).size - 1
        return (0..size).random()
    }

    private fun getCartoonAverage(): String {
        return resources.getStringArray(R.array.cartoonAverage)[randomNumberCartoonAverage()]
    }

    private fun randomNumberCartoonAverage(): Int {
        val size = resources.getStringArray(R.array.cartoonAverage).size - 1
        return (0..size).random()
    }

    private fun getMovieAverage(): String {
        return resources.getStringArray(R.array.movieAverage)[randomNumberMovieAverage()]
    }

    private fun randomNumberMovieAverage(): Int {
        val size = resources.getStringArray(R.array.movieAverage).size - 1
        return (0..size).random()
    }

    private fun getWorkAverage(): String {
        return resources.getStringArray(R.array.workAverage)[randomNumberWorkAverage()]
    }

    private fun randomNumberWorkAverage(): Int {
        val size = resources.getStringArray(R.array.workAverage).size - 1
        return (0..size).random()
    }
}


