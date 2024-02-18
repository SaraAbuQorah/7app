package com.example.openp.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.openp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeNavBottomActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_nav_bottom)


        bottomNav = findViewById(R.id.bottomNavigationView)

        loadFragment(HomeFragment())
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }

                R.id.chat -> {
                    loadFragment(ChatFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.notifications -> {
                    loadFragment(NotificationFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.myAccount -> {
                    loadFragment(AccountFragment())
                    return@setOnItemSelectedListener true
                }

                else -> {
                    loadFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }
            }
        }

    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()

    }
}