package com.f4l.lattop2ch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_intent.setOnClickListener {
            intent()
        }

        btn_bundle.setOnClickListener {
            bundle()
        }

        btn_serial.setOnClickListener {
            serial()
        }

        btn_parce.setOnClickListener {
            parce()
        }

        btn_reset.setOnClickListener {
            reset()
        }

    }

    private fun intent(){
        val umur = iUmur.text.toString()
        val height = iTb.text.toString()
        val weight = iBb.text.toString()
        val bmi = calculate(height.toFloat(), weight.toFloat()).toString()
        val kategori = grade(bmi.toFloat())

        val dataIntent = Intent(this, IntentActivity ::class.java)
        dataIntent.putExtra("dataUmur", umur)
        dataIntent.putExtra("dataTb", height )
        dataIntent.putExtra("dataBb", weight)
        dataIntent.putExtra("dataBmi", bmi)
        dataIntent.putExtra("dataGrade", kategori)

        startActivity(dataIntent)

    }

    private fun bundle(){
        val umur = iUmur.text.toString()
        val height = iTb.text.toString()
        val weight = iBb.text.toString()
        val bmi = calculate(height.toFloat(), weight.toFloat()).toString()
        val kategori = grade(bmi.toFloat())

        val dataBundle = Intent(this,BundleActivity::class.java)
        val bun = Bundle()
        bun.putString("dataUmur",umur)
        bun.putString("dataTb",height)
        bun.putString("dataBb",weight)
        bun.putString("dataBmi",bmi)
        bun.putString("dataGrade",kategori)

        dataBundle.putExtras(bun)
        startActivity(dataBundle)

    }

    private fun serial() {
        val umur = iUmur.text.toString()
        val height = iTb.text.toString()
        val weight = iBb.text.toString()
        val bmi = calculate(height.toFloat(), weight.toFloat()).toString()
        val kategori = grade(bmi.toFloat())

        val dataSerial = Intent(this, SerialActivity::class.java)
        val data = DataSerial(umur,height,weight,bmi,kategori)

        dataSerial.putExtra("dataSerial",data)
        startActivity(dataSerial)
    }

    data class DataSerial(var umur: String, var height: String, var weight: String, var bmi: String, var kategori: String) : Serializable {

    }

    private fun parce() {
        val umur = iUmur.text.toString()
        val height = iTb.text.toString()
        val weight = iBb.text.toString()
        val bmi = calculate(height.toFloat(), weight.toFloat()).toString()
        val kategori = grade(bmi.toFloat())

        val dataParce = Intent(this,ParceActivity::class.java)
        val data = DataParce(umur,height,weight,bmi,kategori)

        dataParce.putExtra("dataParce",data)
        startActivity(dataParce)
    }

    data class DataParce(val umur: String?, val height: String?, val weight: String?, val bmi: String?, val kategori: String?): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(umur)
            parcel.writeString(height)
            parcel.writeString(weight)
            parcel.writeString(bmi)
            parcel.writeString(kategori)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<DataParce> {
            override fun createFromParcel(parcel: Parcel): DataParce {
                return DataParce(parcel)
            }

            override fun newArray(size: Int): Array<DataParce?> {
                return arrayOfNulls(size)
            }
        }

    }

    private fun calculate(weight: Float, height: Float): Float {
        return weight / ((height / 100) * (height / 100))
    }

    private fun grade(bmi : Float) : String{
        var diagnostic = when (bmi) {
            in 0f..16f -> "Telalu Kurus"
            in 16f..17f -> "Cukup Kurus"
            in 17f..18.5f -> "Sedikit Kurus"
            in 18.5f..25f -> "Normal"
            in 25f..30f -> "Gemuk"
            in 30f..35f -> "Obesitas Kelas I"
            in 35f..40f -> "Obesitas Kelas II"
            else -> "Obesitas III"
        }

        return diagnostic
    }

    private fun reset(){
        iUmur.setText("")
        iTb.setText("")
        iBb.setText("")
    }

}