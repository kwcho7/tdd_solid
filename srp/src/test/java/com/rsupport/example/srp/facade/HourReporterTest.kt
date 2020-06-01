package com.rsupport.example.srp.facade

import com.rsupport.example.srp.data.EmployeeData
import org.hamcrest.CoreMatchers.containsString
import org.junit.Assert.assertThat
import org.junit.Test

class HourReporterTest{

    @Test
    fun reportHours() {
        val employeeData = EmployeeData(0, 1000, 8)
        val hourReporter = HourReporter(employeeData)
        val report = hourReporter.reportHours()
        assertThat("데이터가 달라서 실패", report, containsString("8"))
    }
}