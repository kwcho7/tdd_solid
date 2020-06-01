package com.rsupport.example.srp.facade

import com.rsupport.example.srp.data.EmployeeData

class EmployeeSaver(private val employeeData: EmployeeData) {
    fun reportSave(): String {
        return employeeData.let {
            """
                id : ${it.id}
                pay : ${it.pay}
                hours : ${it.hours}
            """.trimIndent()
        }
    }
}