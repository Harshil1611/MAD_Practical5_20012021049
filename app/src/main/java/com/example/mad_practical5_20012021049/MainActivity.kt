package com.example.mad_practical5_20012021049

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.WindowCompat
import com.example.mad_practical5_20012021049.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    public lateinit var binding: ActivityMainBinding
    var toggleButton = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.playButton.setOnClickListener {
            var res = binding.playButton.contentDescription.toString()
            Log.i("HELLO:", "$res")
            Intent(applicationContext, MyService::class.java).putExtra(
                MyService.DATA_KEY,
                MyService.DATA_VALUE
            ).apply { startService(this) }
        }

        binding.stopButton.setOnClickListener {
            Intent(applicationContext, MyService::class.java).apply { stopService(this) }
        }
    }
}