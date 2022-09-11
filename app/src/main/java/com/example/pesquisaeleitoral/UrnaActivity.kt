package com.example.pesquisaeleitoral

import android.app.AlertDialog.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pesquisaeleitoral.domain.Candidatos
import com.example.pesquisaeleitoral.domain.Votos
import com.example.pesquisaeleitoral.extencao.alert

open class UrnaActivity:AppCompatActivity() {
    var votos = Votos(bolsonaro = 0, lula = 0)
    var vencedor = Candidatos()
    var vencendo: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urna)
        findViewById<ImageView>(R.id.btMito).setOnClickListener{
            clickMito()
        }
        findViewById<ImageView>(R.id.btladrao).setOnClickListener{
            clickLadrao()
        }
        findViewById<Button>(R.id.btnRelatorio).setOnClickListener {
            clickRelatorio()
        }

    }


    fun clickRelatorio() {
        var relatorio = findViewById<TextView>(R.id.tsaidarelatorio)

        if(votos.votosMito > votos.votoslula){
            vencendo = "Bolsonaro"
            vencedor.bolsonaro

            val telaMito = Intent(this,TelaVencedorActivity::class.java)
            startActivity(telaMito)
        }else if(votos.votosMito == votos.votoslula){
            vencendo = "Emapatado"
            vencedor.igual

        }else{
            vencendo ="Ladrão"
            vencedor.lula
            val telaLadrao = Intent(this,TelaLadraoActivity::class.java)
            startActivity(telaLadrao)
        }
        relatorio.setText("Votos computados\n\nBolsonaro ${votos.votosMito} voto(s)\nLula Ladrão ${votos.votoslula} voto(s)\nCandidato ${vencendo} esta vencendo")

    }


    private fun clickLadrao() {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
        dialog.setTitle("Eleição 2022")
        dialog.setMessage("Ex-Presidiário,Condenado a mais de 20 anos de cadeia em 3 instância da justica Brasileira," +
                " Lula foi o chefe dos maiores escandalos"+
                " de corrupção do pais, apoia o crime organizado a favor das drogas, a favor do aborto"+
                " contra a familia, apoiador e amigo de ditadores, parceiro das FARC e do PCC\n\nMesmo assim confirma Voto em Lula ladrão ?")
        dialog.setCancelable(false)
        dialog.setPositiveButton(
            "Sim"
        ) { dialogInterface, i ->
            Toast.makeText(
                applicationContext,
                "Voto Registrado",
                Toast.LENGTH_LONG
            ).show()
            alert("Lula é ladrão ?")

            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.bip)
            mediaPlayer.start()
            votos.votoslula++
        }
        dialog.setNegativeButton(
            "Não"
        ) { dialogInterface, i ->
            Toast.makeText(
                applicationContext,
                "Alma salva aleluia irmão",
                Toast.LENGTH_LONG
            ).show()
        }
        dialog.create()
        dialog.show()

    }


    private fun clickMito() {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
        dialog.setTitle("Eleição 2022")
        dialog.setMessage("Presidente é Jair Messias Bolsonaro," +
                "Defensor da vida e da familia, contra as drogas" +
                " e o crime organizado, prega a liberdade e a verdadeira democracia.\n\nMesmo assim confirma Voto em Bolsonaro ?")
        dialog.setCancelable(false)
        dialog.setPositiveButton(
            "Sim"
        ) { dialogInterface, i ->
            Toast.makeText(
                applicationContext,
                "Voto Registrado",
                Toast.LENGTH_LONG
            ).show()

            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.bip)
            mediaPlayer.start()
            votos.votosMito++
        }
        dialog.setNegativeButton(
            "Não"
        ) { dialogInterface, i ->
            Toast.makeText(
                applicationContext,
                "Voto Cancelado",
                Toast.LENGTH_LONG
            ).show()
        }
        dialog.create()
        dialog.show()

    }

}

