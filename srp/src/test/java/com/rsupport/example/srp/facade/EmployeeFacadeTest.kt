package com.rsupport.example.srp.facade

import com.rsupport.example.srp.bad.Employee
import com.rsupport.example.srp.data.EmployeeData
import com.rsupport.example.srp.database.EmployeeDatabase
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class EmployeeFacadeTest {
    private val employeeID = 0
    private val employeeDatabase = EmployeeDatabase()

    @Before
    fun setUp() {
        employeeDatabase.update(EmployeeData(employeeID, 1000, 8))
    }

    @After
    fun tearDown() {
    }


    @Test
    fun calculatorPay() {
        val employeeFacade = EmployeeFacade(employeeID, employeeDatabase)
        val pay = employeeFacade.calculatorPay()
        assertThat("pay 값이 달라서 실패", pay, Matchers.`is`(8000))
    }

    @Test
    fun reportHours() {
        val employee = EmployeeFacade(employeeID, employeeDatabase)
        val report = employee.reportHours()
        assertThat("hour 값이 달라서 실패", report, CoreMatchers.containsString("8"))
    }
}