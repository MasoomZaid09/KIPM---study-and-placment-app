package com.example.kipmnotes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.kipmnotes.R
import com.example.kipmnotes.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mAuth = FirebaseAuth.getInstance()

//      calling Toolbar function
        setUpToolbar()


//       make hamburger icon working
        val actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


//        Adding navigation clicks actions
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){


//                home menu clicks
                R.id.home -> {
                    binding.drawerLayout.closeDrawers()
                }


//                Adding clicks on Study Menu
                R.id.study -> {
                    binding.drawerLayout.closeDrawers()
                }

//                Placements menues clicks
                R.id.placments -> {
                    binding.drawerLayout.closeDrawers()
                }


//                Programming language Clicks
                R.id.language ->{
                    binding.drawerLayout.closeDrawers()
                }


//                Adding clicks on ExtraSkills
                R.id.skills ->{
                    binding.drawerLayout.closeDrawers()
                }

//                Adding clicks on interview
                R.id.interview ->{
                    binding.drawerLayout.closeDrawers()
                }


//              Adding clicks on About Menu
                R.id.about -> {
                    binding.drawerLayout.closeDrawers()
                }


//              Adding Clicks on LogOut
                R.id.logOut ->{
                    mAuth.signOut()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            return@setNavigationItemSelectedListener true
        }


    }

//  Creating an function for setting up toolbar with hamburger icon
    private fun setUpToolbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

//  setting up hamburger icon actions
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home){
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }


}
