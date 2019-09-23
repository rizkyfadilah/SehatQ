package com.rizkyfadilah.sehatq.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.facebook.FacebookSdk
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.Scope
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.ui.home.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar_main.*
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.ui.login
 * Created by rizkyfadilah on 2019-07-31.
 */


class LoginActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    private var googleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        val toolbar: Toolbar by lazy { toolbar_main_activity }
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        prepareGoogleLogin()
        initView()
    }

    private fun initView() {
        toolbar_title.text = "Login"

        FacebookSdk.setApplicationId("449135215614641")
        FacebookSdk.sdkInitialize(this)

        facebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf())
        }

        google.setOnClickListener {
            googleSignInClient?.signInIntent?.let {intent ->
                startActivityForResult(intent, 1290)
            }
        }

        submit.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun prepareGoogleLogin() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("79864932899-5nv875mdgaghakdmp4832ala221ud53r.apps.googleusercontent.com")
            .requestServerAuthCode("79864932899-5nv875mdgaghakdmp4832ala221ud53r.apps.googleusercontent.com")
            .requestEmail()
            .requestProfile()
            .requestScopes(Scope(Scopes.PROFILE))
            .requestScopes(Scope(Scopes.PLUS_ME))
            .requestScopes(Scope(Scopes.PLUS_LOGIN))
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

}