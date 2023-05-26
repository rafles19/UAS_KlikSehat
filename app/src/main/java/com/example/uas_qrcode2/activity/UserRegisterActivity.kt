package com.example.uas_qrcode2.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_qrcode2.R
import com.example.uas_qrcode2.sqlite.DatabaseHelper

class UserRegisterActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_user)

        databaseHelper = DatabaseHelper(this)

        val registerButton = findViewById<Button>(R.id.registerButton)
        registerButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.registerUsernameEditText).text.toString()
            val password = findViewById<EditText>(R.id.registerPasswordEditText).text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Tambahkan pengguna ke database
                databaseHelper.addUser(username, password)

                // Tampilkan pesan sukses
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

                // Pindah ke halaman login
                startActivity(Intent(this, UserLoginActivity::class.java))
            } else {
                // Tampilkan pesan kesalahan
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
