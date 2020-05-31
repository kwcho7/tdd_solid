package com.rsupport.example.srp.bad

import com.rsupport.example.srp.database.EmployeeDatabase
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class EmployeeTest{
    private val employeeDatabase = EmployeeDatabase()

    @Before
    fun setup() {
        employeeDatabase.clear()
    }

    @Test
    fun calcPay() {
        val employeeID = 0

        employeeDatabase.insert(employeeID)
        val employeeData = employeeDatabase.find(employeeID)
        employeeData?.let {
            employeeDatabase.update(it.copy(pay = 1000, hours = 8))
        }

        val employee = Employee(employeeID, employeeDatabase)
        val pay = employee.calcPay()
        assertThat("pay 값이 달라서 실패", pay, `is`(8000))
    }


}