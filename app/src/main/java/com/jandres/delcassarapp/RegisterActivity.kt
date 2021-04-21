package com.jandres.delcassarapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jandres.delcassarapp.databinding.ActivityLoginBinding
import com.jandres.delcassarapp.databinding.ActivityRegisterBinding

const val PASSWORD_LENGTH : Int = 6

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        registerBinding.registerButton.setOnClickListener {
            val email: String = registerBinding.emailTextEdit.text.toString()
            val password: String = registerBinding.passwordTextEdit.text.toString()
            val password2 : String = registerBinding.password2TextEdit.text.toString()

            if (validateData(email,password,password2)){
                goBack(email,password)
            }
            else{
                exceptionsData(email,password,password2)
            }

        }

    }

    private fun goBack(email: String,password: String) {
        val intent = Intent()
        intent.putExtra("email", email)
        intent.putExtra("password", password)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        setResult(Activity.RESULT_OK, intent)
        onBackPressed()
    }

    private fun exceptionsData(email: String,password: String,password2: String) {
        if (email.isBlank()) registerBinding.emailRegisterTextInputLayout.error = "Campo Requerido."
        else if (!checkEmail(email)) registerBinding.emailRegisterTextInputLayout.error = "Correo No Valido."
        else{
            registerBinding.emailRegisterTextInputLayout.error = null
            if (password.isBlank()) registerBinding.passwordRegisterTextInputLayout.error = "Campo Requerido."
            if (password2.isBlank()) registerBinding.password2RegisterTextInputLayout.error = "Campo Requerido."
            else {
                registerBinding.passwordRegisterTextInputLayout.error = null
                if (password != password2) registerBinding.password2RegisterTextInputLayout.error = "Contraseñas No Coinciden."
                else {
                    registerBinding.passwordRegisterTextInputLayout.error = "Minimo 6 Caracteres."
                    registerBinding.password2RegisterTextInputLayout.error = "Minimo 6 Caracteres."
                }
            }

        }
    }

    private fun validateData(email: String,password: String,password2:String) : Boolean {
        return checkEmail(email) && checkLengthPassword(password, PASSWORD_LENGTH) && password == password2
    }

    private fun checkEmail(email: String) : Boolean{
        return email.contains("@") && email.contains(".com")
    }

    private fun checkLengthPassword(password : String,length : Int) : Boolean {
        return password.length >= length
    }


}