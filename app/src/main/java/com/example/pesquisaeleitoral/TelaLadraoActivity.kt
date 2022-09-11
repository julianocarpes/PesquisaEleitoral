package com.example.pesquisaeleitoral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaLadraoActivity : UrnaActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_ladrao)
        saidaLadrao()
    }
    private fun saidaLadrao(){
        val saida =findViewById<TextView>(R.id.ladrao)
        saida.setText("Presidente Eleito ${vencedor.lula}")
    }
}