package com.anurag.jetpacknavigationappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // nav controller is connected to nav host so will get nav controller from nav host
        navController = navHostFragment.navController

        // if theme is no action bar then application will crash because of action bar will set by nav controller so we
        // have to make toolbar
        setSupportActionBar(toobar) // step 1  by this it will work properly

        // this app bar configuration is needed, because if we do not use this bottom nav fragment will show back key on top
        // so to fix this we make all bottom nav fragment as top level destination
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.settingFragment, R.id.notificationFragment),
            drawerLayout  // setup drawerLayout with app bar configuration
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // setup nav controller with bottom navigaiton
        bottomNavigationView.setupWithNavController(navController)

        // setup drawer layout with nav controller
        drawerNavLayout.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(
            appBarConfiguration  // need to pass appBarConfiguration when we use drawer layout for humburgur icon
        ) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_app -> {
                val action = NavGraphDirections.actionGlobalAbounAppFragment()
                navController.navigate(action)
                true
            }
            else -> {
                item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
            }
        }

    }
}