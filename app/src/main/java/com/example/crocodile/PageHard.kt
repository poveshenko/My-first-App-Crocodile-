package com.example.crocodile

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.GravityCompat
import com.example.crocodile.databinding.ActivityPageHardBinding

class PageHard : AppCompatActivity() {
    lateinit var binding: ActivityPageHardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPageHardBinding.inflate(layoutInflater)
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

                if (mediaPlayer2.isPlaying)

                    mediaPlayer2.pause();
                else

                    mediaPlayer2.start();
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
                        val intent = Intent(this@PageHard, MainActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.average -> {
                        val intent = Intent(this@PageHard, PageAverage::class.java)
                        startActivity(intent)
                    }
//
                    R.id.movie -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getMovieHard()
                            mediaPlayer.start()
                        }
                    }

                    R.id.carton -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getCartoonHard()
                            mediaPlayer.start()
                        }
                    }

                    R.id.work -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getWorkHard()
                            mediaPlayer.start()
                        }
                    }

                    R.id.items -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getItemsHard()
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
        object : CountDownTimer(200000, 1000) {


            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = "time: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                binding.timer.text = ("done!")
            }
        }.start()
    }
//    //Средний уровень функции

    private fun getItemsHard(): String {
        return resources.getStringArray(R.array.itemHard)[randomNumberItemHard()]
    }

    private fun randomNumberItemHard(): Int {
        val size = resources.getStringArray(R.array.itemHard).size - 1
        return (0..size).random()
    }

    private fun getCartoonHard(): String {
        return resources.getStringArray(R.array.cartoonHard)[randomNumberCartoonHard()]
    }

    private fun randomNumberCartoonHard(): Int {
        val size = resources.getStringArray(R.array.cartoonHard).size - 1
        return (0..size).random()
    }

    private fun getMovieHard(): String {
        return resources.getStringArray(R.array.movieHard)[randomNumberMovieHard()]
    }

    private fun randomNumberMovieHard(): Int {
        val size = resources.getStringArray(R.array.movieHard).size - 1
        return (0..size).random()
    }

    private fun getWorkHard(): String {
        return resources.getStringArray(R.array.workHard)[randomNumberWorkHard()]
    }

    private fun randomNumberWorkHard(): Int {
        val size = resources.getStringArray(R.array.workHard).size - 1
        return (0..size).random()
    }
}


