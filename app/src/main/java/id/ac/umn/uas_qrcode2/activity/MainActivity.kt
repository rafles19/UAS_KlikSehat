package id.ac.umn.uas_qrcode2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.uas_qrcode2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)
        val regLoginButton = findViewById<Button>(R.id.regLoginButton)
        val userLoginButton = findViewById<Button>(R.id.userLoginButton)
        val adminLoginButton = findViewById<Button>(R.id.adminLoginButton)

        userLoginButton.setOnClickListener {
            startActivity(Intent(this, UserLoginActivity::class.java))
        }

        adminLoginButton.setOnClickListener {
            startActivity(Intent(this, AdminLoginActivity::class.java))
        }

        regLoginButton.setOnClickListener{
            startActivity(Intent(this, UserRegisterActivity:: class.java))
        }
    }
}