package com.example.uas_qrcode2.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_qrcode2.R
import com.example.uas_qrcode2.antrian.QRCode
import com.example.uas_qrcode2.sqlite.DatabaseHelper

class UserLoginActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login)

        databaseHelper = DatabaseHelper(this)

        val userLoginButton = findViewById<Button>(R.id.userLoginButton)
        userLoginButton.setOnClickListener {
            val phoneNumber = findViewById<EditText>(R.id.userPhoneNumberEditText).text.toString()
            val password = findViewById<EditText>(R.id.userPasswordEditText).text.toString()

            val user = databaseHelper.getUser(phoneNumber)

            if (user != null && user.password == password) {
                // Login berhasil
                startActivity(Intent(this, QRCode::class.java))
            } else {
                // Tampilkan pesan kesalahan
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


class UserHomeActivity : AppCompatActivity() {
    // ...
}
