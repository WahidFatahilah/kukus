package com.bangkit.kukus.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.bangkit.kukus.R
import com.bangkit.kukus.data.remote.response.auth.User
import com.bangkit.kukus.databinding.FragmentMainBinding
import com.bangkit.kukus.firebase.FirestoreClass
import com.bangkit.kukus.ui.drawer.Notification
import com.bangkit.kukus.ui.drawer.SettingActivity
import com.bangkit.kukus.ui.login.LoginActivity
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class MainFragment : Fragment() , NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: FragmentMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    val currentUserID = FirestoreClass().getCurrentUserID()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.inflateMenu(R.menu.activity_main_drawer)
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
/*        val navController = findNavController (R.id.nav_host_fragment_content_main)*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (currentUserID.isNotEmpty()){
            FirestoreClass().dataUser(this)
        } else {

        }

        val navView: NavigationView = binding.navView
        val drawerLayout: DrawerLayout = binding.drawerLayout
/*        val navController = Fragment.findNavController(R.id.nav_host_fragment_content_main)*/

        /*  binding.appBarMain.appBarDrawer.btnDrawer.setOnClickListener {
              toggleDrawer()
          }*/



        binding.navView.setNavigationItemSelectedListener(this)


        binding.myToolbar.appBarDrawer.btnDrawer.setOnClickListener {
            toggleDrawer()
        }

        binding.myToolbar.appBarDrawer.btnNotification.setOnClickListener {
            notification()
        }

        /* setupActionBarWithNavController(navController, appBarConfiguration)
         navView.setupWithNavController(navController)*/


    }

    private fun notification() {
        val intent = Intent(requireContext(), Notification::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    fun updateNavigationUserDetails(user: User){

        val headerView = binding.navView.getHeaderView(0)
        val navUserImage = headerView.findViewById<ImageView>(R.id.imageView)
        val userName = headerView.findViewById<TextView>(R.id.username)

        Glide
            .with(this)
            .load(user.image)
            .centerCrop()
            .placeholder(R.drawable.ic_userprofile)
            .into(navUserImage)
        userName.text = user.name
    }

/*

    private fun notification() {
        val intent = Intent(requireActivity(), NotificationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
*/

/*
    override fun onSupportNavigateUp(): Boolean {
        val navController = Fragment.findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


*/

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        when (menuItem.itemId) {
            R.id.nav_setting -> {
                val intent = Intent(requireContext(), SettingActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

            R.id.nav_faq -> {
            }


            R.id.nav_logout -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(requireContext(), LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                activity?.finish()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun toggleDrawer() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    companion object {
        fun updateNavigationUserDetails(mainFragment: MainFragment, user: User){
            val headerView = mainFragment.binding.navView.getHeaderView(0)
            val navUserImage = headerView.findViewById<ImageView>(R.id.imageView)
            val userName = headerView.findViewById<TextView>(R.id.username)

            Glide
                .with(mainFragment)
                .load(user.image)
                .centerCrop()
                .placeholder(R.drawable.ic_userprofile)
                .into(navUserImage)
            userName.text = user.name
        }
    }


}