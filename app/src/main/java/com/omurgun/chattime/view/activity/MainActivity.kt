package com.omurgun.chattime.view.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager.widget.ViewPager
import com.omurgun.chattime.R
import com.omurgun.chattime.adapter.concrete.SectionsPagerAdapter
import com.omurgun.chattime.databinding.ActivityMainBinding
import com.omurgun.chattime.util.ProjectConstants.Companion.PROJECT_NAV_CONTROLLER
import com.omurgun.chattime.view.fragment.CallsFragment
import com.omurgun.chattime.view.fragment.ChatsFragment
import com.omurgun.chattime.view.fragment.StatusFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        this.window.statusBarColor = Color.BLACK
        setupNavHost()
        setContentView(mainBinding.root)
        setSupportActionBar(mainBinding.toolbar)

    }

    private fun setupNavHost(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        PROJECT_NAV_CONTROLLER = navController

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_more -> Toast.makeText(
                this@MainActivity,
                "Action more",
                Toast.LENGTH_LONG
            ).show()
        }
        return super.onOptionsItemSelected(item)
    }


}