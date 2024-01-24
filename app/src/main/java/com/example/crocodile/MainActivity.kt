package com.example.crocodile

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val mediaPlayer = MediaPlayer.create(this, R.raw.click2)
        val mediaPlayer2 = MediaPlayer.create(this, R.raw.music)

        binding.apply {

buttonMusic.setOnClickListener {

    if(mediaPlayer2.isPlaying)

        mediaPlayer2.pause();

    else

        mediaPlayer2.start();

}

            buttonSetting.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }

            NavigationView.setNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.movie -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getMovie()
                            mediaPlayer.start()


                        }
                        drawer.openDrawer(GravityCompat.START)
                    }

                    R.id.carton -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getCartoon()
                        }
                    }

                    R.id.work -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getWork()
                        }
                    }

                    R.id.items -> {
                        buttonPlay.setOnClickListener {
                            textPlay.text = getItems()
                        }
                    }
                }

                true
            }


        }
    }
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
        return resources.getStringArray(R.array.work)[randomNumberMovie()]
    }

    private fun randomNumberWork(): Int {
        val size = resources.getStringArray(R.array.work).size - 1
        return (0..size).random()
    }


    private fun page() {
        val nextPage = Intent(this, ActivityGame::class.java)
        startActivity(nextPage)
    }


}