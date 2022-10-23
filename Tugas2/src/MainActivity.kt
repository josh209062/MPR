package com.example.pertemuan3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var intentExplicitBtn : Button
    lateinit var sendBtn : Button
    lateinit var sendObjBtn : Button
    lateinit var intentImplicitBtn : Button
    lateinit var editPlainText : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentImplicitBtn   = findViewById(R.id.intentImplicitBtn)
        sendBtn             = findViewById(R.id.sendBtn)
        sendObjBtn          = findViewById(R.id.sendObjectBtn)
        intentExplicitBtn   = findViewById(R.id.intentExplixitBtn)
        editPlainText       = findViewById(R.id.editPlainText)
    }

    fun onClick(view: View){
        when(view.id){
            R.id.intentExplixitBtn -> {
                val intent = Intent(this@MainActivity, detail::class.java)
                startActivity(intent)
            }

            R.id.sendBtn -> {
                val text = editPlainText.text.toString()
                val intent = Intent(this@MainActivity, detail::class.java)
                intent.putExtra(detail.EXTRA_TEXT, text)
                startActivity(intent)
            }

            R.id.intentImplicitBtn -> {
                val phoneNumber = "081263293807"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.sendObjectBtn -> {
                val carSpek = Car(
                    "Civic",
                    "Honda",
                    "Sedan",
                    1997,
                    57000000.00
                )

                val intent = Intent(this@MainActivity, detail::class.java)
                intent.putExtra(detail.EXTRA_CAR, carSpek)
                intent.putExtra(detail.EXTRA_BOOL, true)
                startActivity(intent)
            }

        }
    }


}

