package com.example.pesquisaeleitoral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class TelaVencedorActivity : UrnaActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_vencedor)
        saidaMito()

    }
    private fun saidaMito(){
        val saida =findViewById<TextView>(R.id.vencedor)
        saida.setText("Presidente Eleito ${vencedor.bolsonaro}")
    }
}