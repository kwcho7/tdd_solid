package com.rsupport.example.srp.facade

import com.rsupport.example.srp.data.EmployeeData

class PayCalculator(private val employeeData: EmployeeData) {
    fun calculatePay() : Int {
        return employeeData.pay * employeeData.hours
    }
}