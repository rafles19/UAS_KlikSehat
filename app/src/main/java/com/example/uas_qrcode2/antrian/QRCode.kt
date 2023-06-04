package com.example.uas_qrcode2.antrian

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_qrcode2.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class QRCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Button for generating QR code
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val imageCode = findViewById<ImageView>(R.id.imageCode)
        val toEncode= intent.getStringExtra("toEncode")
        if (toEncode != null) {
            Log.d("Encode", toEncode)
        }
        btnGenerate.setOnClickListener { v: View? ->
            //getting text from input text field.
            //initializing MultiFormatWriter for QR code
            val mWriter = MultiFormatWriter()
            try {
                //BitMatrix class to encode entered text and set Width & Height
                val mMatrix = mWriter.encode(toEncode, BarcodeFormat.QR_CODE, 400, 400)
                val mEncoder = BarcodeEncoder()
                val mBitmap = mEncoder.createBitmap(mMatrix) //creating bitmap of code
                imageCode.setImageBitmap(mBitmap) //Setting generated QR code to imageView                // to hide the keyboard
            } catch (e: WriterException) {
                e.printStackTrace()
            }
        }
    }
}