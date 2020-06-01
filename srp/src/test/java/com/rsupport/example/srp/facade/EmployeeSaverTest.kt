package com.rsupport.example.srp.facade

import com.rsupport.example.srp.data.EmployeeData
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test

class EmployeeSaverTest{

    @Test
    fun save() {
        val employeeData = EmployeeData(0, 1000, 8)
        val employeeSaver = EmployeeSaver(employeeData)
        val savedReport = employeeSaver.reportSave()
        assertThat("데이터가 달라서 실패", savedReport, CoreMatchers.containsString("0"))
        assertThat("데이터가 달라서 실패", savedReport, CoreMatchers.containsString("1000"))
        assertThat("데이터가 달라서 실패", savedReport, CoreMatchers.containsString("8"))
    }
}