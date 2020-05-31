package com.rsupport.example.srp.bad

import com.rsupport.example.srp.database.EmployeeDatabase

class Employee(private val id: Int = 0, private val employeeDatabase: EmployeeDatabase) {

    fun calcPay(): Int {
        return employeeDatabase.find(id)?.let {
            it.pay * it.hours
        } ?: 0
    }
}