package com.example.industria3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.*
import android.app.Activity;
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.LinearGradient
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var drawerlayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var textTitle: TextView
    lateinit var textLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.Industria4)


        drawerlayout = findViewById(R.id.nav_drawer_layout)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerlayout,
            toolbar,
            R.string.toggle_open,
            R.string.toggle_close
        )
        drawerlayout.addDrawerListener(toggle)

        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val sobre: LinearLayout = findViewById(R.id.ll_about)

        sobre.setOnClickListener {
            val intent: Intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)

        }
        textLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name)
        textLogin.setOnClickListener{
            val intent=Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onBackPressed() {

        if (drawerlayout.isDrawerOpen(GravityCompat.START))
            drawerlayout.closeDrawer(GravityCompat.START)
        else

            super.onBackPressed()

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.nav_conta -> {
                val intent = Intent (this, UserProfileActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_sobre -> Toast.makeText(this, "Sobre", Toast.LENGTH_LONG).show()
            R.id.nav_voltar -> Toast.makeText(this, "Voltar", Toast.LENGTH_LONG).show()

        }
            drawerlayout.closeDrawer(GravityCompat.START)

              return true
        }
    }
