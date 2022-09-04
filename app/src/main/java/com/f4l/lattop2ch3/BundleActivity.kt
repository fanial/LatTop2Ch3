package com.f4l.lattop2ch3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent.*

class BundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle)
            resultBundle()
    }

    fun resultBundle(){
        val bundle = intent.extras
        result_umur.text = (bundle?.getString("dataUmur") +" tahun")
        result_tb.text = (bundle?.getString("dataTb") +" cm")
        result_bb.text = (bundle?.getString("dataBb") +" kg")
        result.text = bundle?.getString("dataBmi")
        kategori.text = bundle?.getString("dataGrade")
    }
}