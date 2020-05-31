package com.rsupport.example.srp.database

import com.rsupport.example.srp.data.EmployeeData

class EmployeeDatabase {

    private val employeeMap = mutableMapOf<Int, EmployeeData>()

    fun findAll(): List<EmployeeData> {
        return employeeMap.values.toList()
    }

    fun insert(id: Int): Boolean {
        if(employeeMap.containsKey(id)) return false
        employeeMap[id] = EmployeeData(id)
        return true
    }

    fun clear() {
        employeeMap.clear()
    }

    fun update(employeeData: EmployeeData) {
        employeeMap[employeeData.id]?.let {
            employeeMap[it.id] = employeeData
        } ?: run {
            employeeMap[employeeData.id] = employeeData
        }
    }
}