package id.ac.umn.uas_qrcode2.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_qrcode2.R
import id.ac.umn.uas_qrcode2.antrian.QRCode
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login)

        val database = Firebase.database("https://map-kliksehat-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")
        // Read from the database

        val userLoginButton = findViewById<Button>(R.id.userLoginButton)
        userLoginButton.setOnClickListener {
            val phoneNumber = findViewById<EditText>(R.id.userPhoneNumberEditText).text.toString()
            val password = findViewById<EditText>(R.id.userPasswordEditText).text.toString()

            myRef.child(phoneNumber).get().addOnSuccessListener {

                Log.i("firebase", "Got value ${it.child("password").value}")

                if (it != null && password == it.child("password").value ) {
                    // Login berhasil
                    Log.d("Here", "is here")
                    val intent = Intent(this, QRCode::class.java)
                    intent.putExtra("toEncode", it.child("id").value as String)
                    Log.i("firebase", "Got value ${it.child("id").value}")
                    startActivity(intent)
                } else {
                    // Tampilkan pesan kesalahan
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
            }

        }
    }
}


class UserHomeActivity : AppCompatActivity() {
    // ...
}
