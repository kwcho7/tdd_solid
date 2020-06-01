package com.rsupport.example.srp.facade

import com.rsupport.example.srp.database.EmployeeDatabase

class EmployeeFacade(private val id: Int, private val employeeDatabase: EmployeeDatabase) {

    fun calculatorPay(): Int {
        return employeeDatabase.find(id)?.let {
            PayCalculator(it).calculatePay()
        } ?: 0
    }

    fun reportHours(): String {
        return employeeDatabase.find(id)?.let {
            HourReporter(it).reportHours()
        } ?: ""
    }


}