package com.rsupport.example.srp.database

import com.rsupport.example.srp.data.EmployeeData
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class EmployeeDatabaseTest{
    private val employeeDatabase = EmployeeDatabase()

    @Before
    fun setup() {
        employeeDatabase.clear()
    }

    @Test
    fun getAll() {
        val employeeDataList = employeeDatabase.findAll()
        assertThat("데이터가 없어서 실패", employeeDataList.size, `is`(0))
    }

    @Test
    fun insert() {
        val insertResult = employeeDatabase.insert(0)
        assertThat("신규 id 생성을 실패", insertResult, `is`(true))
    }

    @Test
    fun insertWhenAlreadyID() {
        employeeDatabase.insert(0)
        val insertResult = employeeDatabase.insert(0)
        assertThat("신규 id 생성 되서 실패", insertResult, `is`(false))
    }

    @Test
    fun clear() {
        employeeDatabase.insert(0)
        employeeDatabase.clear()
        val employeeDataList = employeeDatabase.findAll()
        assertThat("삭제가 안되서 실패", employeeDataList.size, `is`(0))
    }

    @Test
    fun update() {
        employeeDatabase.insert(0)
        val employeeData = employeeDatabase.findAll().first { it.id == 0 }
        employeeDatabase.update(employeeData.copy(pay = 1000))
        val updatedEmployeeData = employeeDatabase.findAll().first { it.id == 0 }

        assertThat("pay 가 변경되지 않아서 실패", updatedEmployeeData.pay, `is`(1000))
    }

    @Test
    fun updateNotFoundData() {
        employeeDatabase.update(EmployeeData(0, pay = 1000))
        val updatedEmployeeData = employeeDatabase.findAll().first { it.id == 0 }
        assertThat("data 가 insert 안되서 실패", updatedEmployeeData.pay, `is`(1000))
    }
}
