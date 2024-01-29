package com.project.adulting.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.adulting.R
import com.project.adulting.databinding.ActivityMainBinding
import com.project.adulting.ui.tasks.TasksFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = TasksFragment()
        fragmentTransaction.replace(R.id.fcb_main_fragment_container_view,fragment)
        fragmentTransaction.commit()
    }
}