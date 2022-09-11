package com.example.pesquisaeleitoral.extencao

import android.media.MediaPlayer
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pesquisaeleitoral.R

fun AppCompatActivity.alert(msg:String){
    val dialog = AlertDialog.Builder(this).create()
    dialog.setTitle("Eleições 2022")
    dialog.setMessage(msg)
    dialog.setButton(
        AlertDialog.BUTTON_POSITIVE,"Sim"){
            _,which ->dialog.dismiss()
        }
    /*dialog.setButton(
        AlertDialog.BUTTON_NEGATIVE,"Não"){
            _,which ->dialog.dismiss()
    }*/
    dialog.show()


}