package com.jandres.delcassarapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jandres.delcassarapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    private var email: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        val dataImported = intent.extras
        email = dataImported?.getString("email").toString()
        password = dataImported?.getString("password").toString()
        if(email != "null") loginBinding.emailInputEditText.setText(email)

        loginBinding.loginButton.setOnClickListener {

            val emailAux : String = loginBinding.emailInputEditText.text.toString()
            val passwordAux : String = loginBinding.passwordInputEditText.text.toString()

            if(checkUser(emailAux) && checkPassword(passwordAux)){
                loginBinding.emailInputEditText.error = null
                loginBinding.passwordInputEditText.error = null
                goToMainActivity(email,password)
            }
            else{
                if (emailAux.isBlank()) Toast.makeText(this,R.string.email_blank,2.toInt()).show()
                else{
                    if(!checkUser(emailAux)) loginBinding.emailTextInputLayout.error = "Usuario No Existe."
                    else loginBinding.passwordTextInputLayout.error = "Contraseña Incorrecta."
                }

            }

        }

        loginBinding.registerTextView.setOnClickListener {
            goToRegisterActivity()
        }

    }

    private fun goToMainActivity(email : String, password : String){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("email",email)
        intent.putExtra("password",password)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
        startActivityForResult(intent,1235)
    }

    private fun goToRegisterActivity(){
        val intent = Intent(this,RegisterActivity::class.java)
        startActivityForResult(intent,1234)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234 && resultCode == Activity.RESULT_OK){
            loginBinding.emailTextInputLayout.error = null
            loginBinding.passwordTextInputLayout.error = null

            loginBinding.passwordInputEditText.setText("")

            email = data!!.extras?.getString("email").toString()
            password = data!!.extras?.getString("password").toString()
        }
        if(requestCode == 1235 && resultCode == Activity.RESULT_OK){
            loginBinding.emailInputEditText.setText(email)
        }
    }

    private fun checkUser(email2 : String) : Boolean{
        return if (email2.isNotEmpty() && email.isNotEmpty()){
            email == email2
        }
        else false
    }
    private fun checkPassword(password2 : String) : Boolean {
        return if (password2.isNotEmpty() && password.isNotEmpty()){
            password == password2
        }
        else false
    }
}