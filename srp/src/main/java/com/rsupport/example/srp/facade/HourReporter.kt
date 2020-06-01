package com.rsupport.example.srp.facade

import com.rsupport.example.srp.data.EmployeeData

class HourReporter(val employeeData: EmployeeData) {
    fun reportHours(): String {
        return employeeData.let {
            "${it.id} is worked ${it.hours} hours"
        }
    }
}