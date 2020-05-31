package com.rsupport.example.srp.bad

import com.rsupport.example.srp.database.EmployeeDatabase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.containsString
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class EmployeeTest{
    private val employeeDatabase = EmployeeDatabase()
    private val employeeID = 0

    @Before
    fun setup() {
        employeeDatabase.clear()
        employeeDatabase.insert(employeeID)
        val employeeData = employeeDatabase.find(employeeID)
        employeeData?.let {
            employeeDatabase.update(it.copy(pay = 1000, hours = 8))
        }
    }

    @Test
    fun calcPay() {
        val employee = Employee(employeeID, employeeDatabase)
        val pay = employee.calcPay()
        assertThat("pay 값이 달라서 실패", pay, `is`(8000))
    }

    @Test
    fun reportHours() {
        val employee = Employee(employeeID, employeeDatabase)
        val report = employee.reportHours()
        assertThat("hour 값이 달라서 실패", report, containsString("8"))
    }

    @Test
    fun save() {
        val employee = Employee(employeeID, employeeDatabase)
        val savedReport = employee.reportSave()
        assertThat("데이터가 달라서 실패", savedReport, containsString("0"))
        assertThat("데이터가 달라서 실패", savedReport, containsString("1000"))
        assertThat("데이터가 달라서 실패", savedReport, containsString("8"))
    }


}