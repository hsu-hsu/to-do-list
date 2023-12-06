package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnZeroHundred() {
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_bith_returnFortySixty() {
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnZeros() {
        val tasks = emptyList<Task>()
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_zero_returnZeros() {
        val tasks = null
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}