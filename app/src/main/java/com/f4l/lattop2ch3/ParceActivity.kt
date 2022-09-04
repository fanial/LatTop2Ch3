package com.f4l.lattop2ch3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent.*
import kotlinx.android.synthetic.main.activity_parce.*
import kotlinx.android.synthetic.main.activity_parce.kategori
import kotlinx.android.synthetic.main.activity_parce.result
import kotlinx.android.synthetic.main.activity_parce.result_bb
import kotlinx.android.synthetic.main.activity_parce.result_tb
import kotlinx.android.synthetic.main.activity_parce.result_umur

class ParceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parce)
        resultParce()
    }

    private fun resultParce() {
        val dataParce = intent.getParcelableExtra("dataParce") as MainActivity.DataParce?
        result_umur.text = (dataParce?.umur +" tahun")
        result_tb.text = (dataParce?.height +" cm")
        result_bb.text = (dataParce?.weight +" kg")
        result.text = dataParce?.bmi
        kategori.text = dataParce?.kategori
    }


}