package com.example.lab6v2023_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import java.util.*

class Prezenty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //WebView - kontrolka wyswietlajaca html
        val page = WebView(this)

        //wlaczenie obslugi JS
        page.settings.javaScriptEnabled=true

        //dodanie interfejsu pomiędzy Kotlinem a JS
        //this - obiekt tej klasy dostarcza metody JSInterface, activity - nazwa widoczna w JS
        page.addJavascriptInterface(this, "activity")

        //zaladowanie zawartosci kontroli WebView - pliki z katalogu assests w projekcie
        page.loadUrl("file:///android_asset/Prezenty.html")

        //wstawienie kontrolki WebView jako calej fasady aktywnosci
        setContentView(page)
    }

    @JavascriptInterface //adnotacja sygnalizujaca ze metoda bedzie dostepna z poziomu JS
    fun sayHello(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

    @JavascriptInterface
    fun getDate(): String {
        return Date().toString()
    }
}