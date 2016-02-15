package com.kotlinchina.logindemo.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.jakewharton.rxbinding.widget.RxTextView
import rx.Observable

class LoginActivity : AppCompatActivity() {
    private var usernameEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupUI()
        setupAction()
    }

    private fun setupUI() {
        usernameEditText = findViewById(R.id.usernameEditText) as EditText
        passwordEditText = findViewById(R.id.passwordEditText) as EditText
        loginButton = findViewById(R.id.loginButton) as Button
    }

    private fun setupAction() {
        val usernameET = usernameEditText
        val passwordET = passwordEditText
        if (usernameET != null
                && usernameET is EditText
                && passwordET != null
                && passwordET is EditText) {
            Observable.combineLatest(RxTextView.textChanges(usernameET), RxTextView.textChanges(passwordET), {
                username, password ->
                shoudShowLogin(password, username)
            }).subscribe { result ->
                loginButton?.isEnabled = result
            }
        }
    }

    private fun shoudShowLogin(password: CharSequence, username: CharSequence) = username.length > 0 && password.length > 0
}
