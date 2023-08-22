package com.example.courtains

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.courtains.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            Cambio()
        }

        binding.btn1.setOnClickListener {
            AgregarTiempo()
        }
    }

    private fun Cambio(){
        val intent = Intent(this, Progress::class.java)
        intent.putExtra("Time", binding.txtTime.toString())
        startActivity(intent)
    }

    private fun AgregarTiempo(){
        
    }


}