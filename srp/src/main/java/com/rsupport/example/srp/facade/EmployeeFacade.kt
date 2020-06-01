package com.rsupport.example.srp.facade

import com.rsupport.example.srp.database.EmployeeDatabase

class EmployeeFacade(private val id: Int, private val employeeDatabase: EmployeeDatabase) {

    fun calculatorPay(): Int {
        return findEmployeeDataOrNull()?.let {
            PayCalculator(it).calculatePay()
        } ?: 0
    }

    fun reportHours(): String {
        return findEmployeeDataOrNull()?.let {
            HourReporter(it).reportHours()
        } ?: ""
    }

    fun reportSave(): String {
        return findEmployeeDataOrNull()?.let {
            EmployeeSaver(it).reportSave()
        } ?: ""
    }

    private fun findEmployeeDataOrNull() = employeeDatabase.find(id)

}