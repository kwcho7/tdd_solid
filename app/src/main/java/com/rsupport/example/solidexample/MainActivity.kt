package com.rsupport.example.solidexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rsupport.example.ocp.activities.pdf.PDFViewActivity
import com.rsupport.example.ocp.activities.web.WebViewActivity
import com.rsupport.example.ocp.database.FinancialDatabase
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.java.KoinJavaComponent.inject

class MainActivity : AppCompatActivity() {

    private val database by inject(FinancialDatabase::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database.apply {
            clear()
            insert(0, "Rsupport", 1000)
        }

        setContentView(R.layout.activity_main)

        webViewButton.setOnClickListener { startActivity(Intent(this, WebViewActivity::class.java)) }
        pdfViewButton.setOnClickListener { startActivity(Intent(this, PDFViewActivity::class.java)) }
    }
}
