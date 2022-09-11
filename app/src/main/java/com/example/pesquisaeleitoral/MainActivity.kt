package com.example.pesquisaeleitoral

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tVotar).setOnClickListener{
            iniciaVotos()
        }
    }

    private fun iniciaVotos() {
       val inicia = Intent(this, UrnaActivity:: class.java)
        startActivity(inicia)
    }


}