package com.project.adulting.ui.tasks

data class Task(val text: String, val type: TaskType) {
}

sealed class TaskType {
    data object Business : TaskType()
    data object Personal : TaskType()
    data object Other : TaskType()

}
