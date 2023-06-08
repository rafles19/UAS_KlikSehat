package id.ac.umn.uas_qrcode2.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_qrcode2.R
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class AdminDashboard : AppCompatActivity() {

    private lateinit var qrCodeScannerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_dashboard)

        qrCodeScannerButton = findViewById(R.id.openCameraButton)
        qrCodeScannerButton.setOnClickListener {
            startQRCodeScanner()
        }
    }

    private fun startQRCodeScanner() {
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null && result.contents != null) {
            val scannedText: String = result.contents
            // Lakukan sesuatu dengan hasil pemindaian kode QR di sini
        }
    }
}
