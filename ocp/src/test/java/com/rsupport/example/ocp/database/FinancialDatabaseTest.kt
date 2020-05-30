package com.rsupport.example.ocp.database

import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class FinancialDatabaseTest{
    private lateinit var financialDatabase: FinancialDatabase

    @Before
    fun setup() {
        financialDatabase = FinancialDatabase()
    }

    @Test
    fun insertData() {
        val insertResult = insertRsupport1000()
        assertThat("데이터가 삽입되지 않아서 실패", insertResult, `is`(true))
    }

    @Test
    fun insertDataWhenAlreadyCompany() {
        insertRsupport1000()
        val insertResult = insertRsupport1000()
        assertThat("같은데이터를 삽입했는데 성공했다.", insertResult, `is`(false))
    }

    @Test
    fun deleteData() {
        insertRsupport1000()
        val deleteResult = deleteRsupport()
        assertThat("데이터가 삭제를 못해서 실패", deleteResult, `is`(true))
    }


    @Test
    fun deleteDataWhenNotFound() {
        insertRsupport1000()
        val deleteResult = deleteNotFound()
        assertThat("데이터가 없는데 삭제 성공해서 실패", deleteResult, `is`(false))
    }

    @Test
    fun findData() {
        insertRsupport1000()
        val datas = findRsupport()
        assertThat("데이터를 찾지 못해서 실패", datas, notNullValue())
    }


    @Test
    fun findDataWhenNotFound() {
        insertRsupport1000()
        val datas = findFailure()
        assertThat("데이터가 없는데 찾아져서 실패", datas, nullValue())
    }

    private fun findFailure() = financialDatabase.findById(1)
    private fun findRsupport() = financialDatabase.findById(0)
    private fun insertRsupport1000() = financialDatabase.insert(0, "rsupport", 1000)
    private fun deleteRsupport() = financialDatabase.delete(0)
    private fun deleteNotFound() = financialDatabase.delete(1)

}