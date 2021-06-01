package ru.magizoo.magizoo.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import ru.magizoo.core.navigation.NavControllerHolder
import ru.magizoo.core.ui.BaseFragment
import ru.magizoo.core.ui.viewBinding
import ru.magizoo.magizoo.R
import ru.magizoo.magizoo.databinding.ActivityMainHostBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainHostActivity : AppCompatActivity() {

    @Inject
    lateinit var navControllerHolders: Array<NavControllerHolder>

    private val binding by viewBinding<ActivityMainHostBinding>()

    private val navController: NavController by lazy {
        navHostFragment.findNavController()
    }

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.mainHostContainer) as NavHostFragment
    }

    private lateinit var mainBottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_host)

        initNavControllerListener()
        setNavControllerToNavigators()
        initMainBottomNavigation()
        setBottomBarVisibility(false)
    }

    private fun setBottomBarVisibility(isBottomBarVisible: Boolean) {
        if (isBottomBarVisible) {
            mainBottomNavigation.visibility = View.VISIBLE
        } else {
            mainBottomNavigation.visibility = View.GONE
        }
    }

    private fun setNavControllerToNavigators() {
        navControllerHolders.forEach { it.navController = navController }
    }

    private fun initMainBottomNavigation() {
        mainBottomNavigation = findViewById(R.id.main_bottom_navigation)
        mainBottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_home -> {
                    if (navController.currentDestination?.id != R.id.homeFragment) {
                        navController.navigate(R.id.action_global_homeFragment)
                        return@setOnNavigationItemSelectedListener true
                    } else {
                        return@setOnNavigationItemSelectedListener false
                    }
                }
                R.id.action_catalog -> {
                    if (navController.currentDestination?.id != R.id.catalogFragment) {
                        navController.navigate(R.id.action_global_catalogFragment)
                        return@setOnNavigationItemSelectedListener true
                    } else {
                        return@setOnNavigationItemSelectedListener false
                    }
                }
                R.id.action_basket -> {
                    if (navController.currentDestination?.id != R.id.basketFragment) {
                        navController.navigate(R.id.action_global_basketFragment)
                        return@setOnNavigationItemSelectedListener true
                    } else {
                        return@setOnNavigationItemSelectedListener false
                    }
                }
                R.id.action_profile -> {
                    if (navController.currentDestination?.id != R.id.profileFragment) {
                        navController.navigate(R.id.action_global_profileFragment)
                        return@setOnNavigationItemSelectedListener true
                    } else {
                        return@setOnNavigationItemSelectedListener false
                    }
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun initNavControllerListener() {
        navHostFragment.childFragmentManager.addFragmentOnAttachListener { _, fragment ->
            if (fragment is BaseFragment) {
                setBottomBarVisibility(fragment.isVisibleBottomNavigationBar)
            }
        }

        navHostFragment.childFragmentManager.addOnBackStackChangedListener {
            if (navHostFragment.childFragmentManager.fragments.isNotEmpty()) {
                val fragment = navHostFragment.childFragmentManager.fragments.last()
                if (fragment is BaseFragment) {
                    setBottomBarVisibility(fragment.isVisibleBottomNavigationBar)
                }
            }
        }
    }

}