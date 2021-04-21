package com.jandres.delcassarapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.jandres.delcassarapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var mainBinding: ActivityMainBinding
    private lateinit var email : String
    private lateinit var password : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val data = intent.extras
        email = data?.getString("email").toString()
        password = data?.getString("password").toString()

        mainBinding.textView4.text = email
        //mainBinding.textView3.text = data?.getString("password")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.logout_menu -> {
                val intent = Intent(this,LoginActivity::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("metodo","onDestroy")
    }
}