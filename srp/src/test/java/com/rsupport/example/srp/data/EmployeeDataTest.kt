package com.rsupport.example.srp.data

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class EmployeeDataTest{

    @Test
    fun getPay() {
        val employeeData = EmployeeData(0, pay = 1000)
        val pay = employeeData.pay
        assertThat("입력된 pay 가 달라서 실패", pay, `is`(1000))
    }

    @Test
    fun getHours() {
        val employeeData = EmployeeData(0, hours = 8)
        val hours = employeeData.hours
        assertThat("입력된 hours 가 달라서 실패", hours, `is`(8))
    }
}