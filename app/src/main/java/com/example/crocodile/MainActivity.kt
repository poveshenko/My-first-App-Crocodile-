package com.example.crocodile

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import com.example.crocodile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var timer: CountDownTimer
    lateinit var binding: ActivityMainBinding
    private var isPlaying = false


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //Музыкальное сопровождение
        val mediaPlayer = MediaPlayer.create(this, R.raw.click2)
        val mediaPlayer2 = MediaPlayer.create(this, R.raw.music_sax)


        //Подключение binding класса
        binding.apply {

            buttonBack.setOnClickListener{
                val start = Intent(this@MainActivity, MainMenu::class.java)
                startActivity(start)
            }


            //Подключение кнопки таймера
            buttonStartTimer.setOnClickListener {

                playTimer()

                mediaPlayer.start()
            }

            buttonStopTimer.setOnClickListener {
                playTimerStop()

                mediaPlayer.start()
            }


// Подключение кнопки для включение и выключения музыки
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


//Подключение меню навигации(Боковое меню)

            NavigationView.setNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.average -> {
                        val intent = Intent(this@MainActivity, PageAverage::class.java)
                        startActivity(intent)
                    }
                    R.id.hard -> {
                        val intent = Intent(this@MainActivity, PageHard::class.java)
                        startActivity(intent)
                    }

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
       timer = object : CountDownTimer(30000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = "time: " + millisUntilFinished / 1000
            }
            override fun onFinish() {
                binding.timer.text = ("done!")
            }
        }.start()

        //функция рестарт/стоп
    }
//    private fun playTimerRestart() {
//        if(!isPlaying){
//            playTimer()
//            binding.buttonStartTimer.text="СТОП"
//            isPlaying=true
//        }else{
//            timer.cancel()
//            binding.buttonStartTimer.text="РЕСТАРТ"
//            isPlaying=false
//        }
//    }
    private fun playTimerStop() {
        timer.cancel()
    }



}


