package com.rizkyfadilah.sehatq.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.core.FragmentFactory
import com.rizkyfadilah.sehatq.ui.order.OrderActivity
import com.rizkyfadilah.sehatq.ui.search.SearchActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_home.*
import kotlinx.android.synthetic.main.toolbar_main.toolbar_main_activity


class MainActivity : DaggerAppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar by lazy { toolbar_main_activity }
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        initView()
        showHomeFragment()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.home_menu -> {
                showHomeFragment()
                return false
            }
            R.id.search_menu -> {
                startActivity(Intent(this, SearchActivity::class.java))
                return false
            }
            R.id.favorite_menu -> {
                return false
            }
            R.id.order -> {
                startActivity(Intent(this, OrderActivity::class.java))
                return false
            }
        }
        return true
    }

    private fun initView() {
        bottomBar.setOnNavigationItemSelectedListener(this)
        search.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }

    private fun showHomeFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                FragmentFactory.getHomeFragment(supportFragmentManager),
                HomeFragment.FRAGMENT_NAME
            )
        fragmentTransaction.addToBackStack(HomeFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }
}
