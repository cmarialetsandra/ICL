package com.iprocen.icl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val backgroud = object: Thread(){
            override fun run(){
                try{
                    Thread.sleep(2500)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }catch(e: Exception){
                    e.printStackTrace()
                }
            }
        }
        backgroud.start()
    }
}
