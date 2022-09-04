package com.f4l.lattop2ch3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        // Intent
        resultIntent()
    }

    private fun resultIntent() {
        var getUmur = intent.getStringExtra("dataUmur")
        var getTb = intent.getStringExtra("dataTb")
        var getBb = intent.getStringExtra("dataBb")
        var getBmi = intent.getStringExtra("dataBmi")
        var getKategori = intent.getStringExtra("dataGrade")


        result_umur.text = "$getUmur tahun"
        result_tb.text = "$getTb cm"
        result_bb.text = "$getBb kg"
        result.text = getBmi
        kategori.text = getKategori
    }


}