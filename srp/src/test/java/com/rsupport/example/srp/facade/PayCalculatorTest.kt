package com.rsupport.example.srp.facade

import com.rsupport.example.srp.data.EmployeeData
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PayCalculatorTest{


    @Test
    fun calcPay() {
        val employeeData = EmployeeData(0, 1000, 8)
        val payCalculator = PayCalculator(employeeData)
        val pay = payCalculator.calculatePay()
        assertThat("pay 값이 달라서 실패", pay, `is`(8000))
    }
}