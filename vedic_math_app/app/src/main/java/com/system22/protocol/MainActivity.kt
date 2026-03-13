package com.ackeles.stringmeme

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.ackeles.stringmeme.R

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize WebView
        webView = findViewById(R.id.webview)
        
        // Configure WebView settings
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = false
        webSettings.displayZoomControls = false
        webSettings.allowFileAccess = true
        webSettings.allowContentAccess = true
        
        // Set WebViewClient to handle page navigation
        webView.webViewClient = WebViewClient()
        
        // Load your HTML file from assets
        webView.loadUrl("file:///android_asset/www/index.html")
    }
    
    // Handle back button to navigate WebView history
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}