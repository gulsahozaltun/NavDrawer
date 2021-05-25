package com.example.navdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val toggle=ActionBarDrawerToggle(this,drawer,toolbar,0,0)
        drawer.addDrawerListener(toggle)
        toggle.syncState()



        nav_view.setNavigationItemSelectedListener { it->

            if(it.itemId == R.id.homeFragment){
                fragment=HomeFragment()

            }
            if(it.itemId==R.id.profilFragment){
                fragment=ProfilFragment()
            }
            if(it.itemId==R.id.favoriteFragment){
                fragment=FavoriteFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()

            drawer.closeDrawer(GravityCompat.START)
            true
        }



    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
        else{
            val intent=Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}