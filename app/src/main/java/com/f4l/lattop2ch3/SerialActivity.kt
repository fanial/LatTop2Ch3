package com.f4l.lattop2ch3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_parce.*

class SerialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serial)

            resultSerial()
    }

    private fun resultSerial() {
        val data = intent.getSerializableExtra("dataSerial") as MainActivity.DataSerial
        result_umur.text = "${data.umur} tahun"
        result_tb.text = "${data.height} cm"
        result_bb.text = "${data.weight} kg"
        result.text = "${data.bmi}"
        kategori.text = "${data.kategori}"
    }
}