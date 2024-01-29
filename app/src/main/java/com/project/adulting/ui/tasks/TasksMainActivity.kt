package com.project.adulting.ui.tasks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.adulting.databinding.ActivityTasksMainBinding

class TasksMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTasksMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasksMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}