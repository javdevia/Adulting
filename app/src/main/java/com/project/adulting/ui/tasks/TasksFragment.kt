package com.project.adulting.ui.tasks

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.adulting.R
import com.project.adulting.databinding.DialogTasksBinding
import com.project.adulting.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    private var tasksList: MutableList<Task> = mutableListOf()
    private var tasksAdapter: TasksAdapter? = null
    private var rvTasks: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTasksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTasks = binding.rvTasks
        initUi()
        initListeners()
    }

    private fun initUi() {
        tasksAdapter = TasksAdapter(tasksList)
        rvTasks!!.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvTasks!!.adapter = tasksAdapter
    }

    private fun initListeners() {
        binding.btnNewTask.setOnClickListener() {
            showDialog()
        }
    }

    private fun showDialog() {
        Log.d("JAVDEVIA","Se entra a show dialog")
        val dialog = Dialog(this.requireContext())
        val dialogBinding = DialogTasksBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        dialogBinding.btnCreateNewTask.setOnClickListener {
            val currentTask = dialogBinding.etTitleInput.text.toString()
            if (currentTask.isNotEmpty()) {

                //Define task type
                val selectedId = dialogBinding.rgTaskType.checkedRadioButtonId
                val selectedTaskType: RadioButton =
                    dialogBinding.rgTaskType.findViewById(selectedId)
                val currentType = when (selectedTaskType.text.toString()) {
                    getString(R.string.business) -> TaskType.Business
                    getString(R.string.personal) -> TaskType.Personal
                    else -> TaskType.Other
                }

                // Input new task
                setNewTask (Task(currentTask,currentType))

                dialog.hide()

            } else {
                Toast.makeText(requireContext(), "Task name required", Toast.LENGTH_LONG).show()
            }
        }
        dialog.show()
    }

    private fun setNewTask (task: Task){
        tasksList.add(task)
        tasksAdapter?.refresh(tasksList)
    }
}

