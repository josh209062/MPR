package com.example.pertemuan3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvGetText : TextView = findViewById(R.id.textView2)
        val getText = intent.getStringExtra(EXTRA_TEXT)
        val getBool = intent.getBooleanExtra(EXTRA_BOOL, false)

        tvGetText.text = getText

        intent.getParcelableExtra<Car>(EXTRA_CAR)

        if (getBool == true){
            val getCar = intent?.getParcelableExtra<Car>(EXTRA_CAR)
            Log.i("Tag", getCar?.name.toString())

            val carSpek = "Car Specification: \n" +
                    "\nName: ${getCar?.name.toString()}" +
                    "\nBrand: ${getCar?.brand.toString()}" +
                    "\nType: ${getCar?.type.toString()}" +
                    "\nYear: ${getCar?.year.toString()}" +
                    "\nPrice: ${getCar?.price.toString()}"
            tvGetText.text = carSpek

        }


    }
    companion object{
        const val EXTRA_TEXT = "extra_text"
        const val EXTRA_BOOL = "extra_bool"
        const val EXTRA_CAR = "extra_car"
    }
}

