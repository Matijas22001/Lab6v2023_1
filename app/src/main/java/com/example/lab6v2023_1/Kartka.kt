package com.example.lab6v2023_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Kartka : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //WebView - kontrolka wyswietlajaca html
        val page = WebView(this)

        //wlaczenie obslugi JS
        page.settings.javaScriptEnabled=true

        //dodanie interfejsu pomiędzy Kotlinem a JS
        //this - obiekt tej klasy dostarcza metody JSInterface, activity - nazwa widoczna w JS
        //page.addJavascriptInterface(this, "activity") //ODKOMENTOWAC DLA JS

        //zaladowanie zawartosci kontroli WebView - pliki z katalogu assests w projekcie
        page.loadUrl("file:///android_asset/Kartka.html")

        //wstawienie kontrolki WebView jako calej fasady aktywnosci
        setContentView(page)


    }
}