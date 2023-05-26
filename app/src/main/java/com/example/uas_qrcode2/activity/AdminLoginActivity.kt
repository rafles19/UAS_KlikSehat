package com.example.uas_qrcode2.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_qrcode2.R
import com.example.uas_qrcode2.antrian.QRCode
import com.example.uas_qrcode2.dashboard.AdminDashboard
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AdminLoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_login)
        // Initialize Firebase Auth
        auth = Firebase.auth

        val adminLoginButton = findViewById<Button>(R.id.adminLoginButton)
        adminLoginButton.setOnClickListener {
            val pin = findViewById<EditText>(R.id.adminPinEditText).text.toString()

            // Lakukan proses login admin di sini
            if (pin == "1234") {
                // Contoh pindah ke halaman lain setelah login sukses
//                startActivity(Intent(this, AdminHomeActivity::class.java))
                Toast.makeText(this, "Valid PIN", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AdminDashboard::class.java))
            } else {
                // Tampilkan pesan kesalahan
                Toast.makeText(this, "Invalid PIN", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

class AdminHomeActivity : AppCompatActivity() {
    // ...
}
