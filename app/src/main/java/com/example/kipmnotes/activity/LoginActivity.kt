package com.example.kipmnotes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kipmnotes.R
import com.example.kipmnotes.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

const val REQUEST_CODE_SIGN_IN = 0


class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient


//    Initialize Firebase in app
    private lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //connect to app
        auth  = Firebase.auth


        //Add click Listerners on GoogleSignInButton
        binding.googleLoginButton.setOnClickListener {
            googleSignINMethod()
        }
    }

    private fun googleSignINMethod(){
        // Adding google sign in method in App
        val gso =  GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()


        // get popup window of google signin
        googleSignInClient = GoogleSignIn.getClient(this, gso)


        // intent through google signIn button
        googleSignInClient.signInIntent.also {
            startActivityForResult(it, REQUEST_CODE_SIGN_IN)
        }
    }



//  override this function for get actual result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SIGN_IN){
            val account = GoogleSignIn.getSignedInAccountFromIntent(data).result
            account?.let {
                googleAuthFirFirebase(it)
            }
        }
    }

//    get credential and take action according to data
    private fun googleAuthFirFirebase(account:GoogleSignInAccount){
        val credentials = GoogleAuthProvider.getCredential(account.idToken,null)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                auth.signInWithCredential(credentials)
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
                finish()

            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@LoginActivity,e.message,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

//  check login already or not
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        currentUser?.let{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }



}