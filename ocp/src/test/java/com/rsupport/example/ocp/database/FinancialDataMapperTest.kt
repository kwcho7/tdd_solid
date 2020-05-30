package com.rsupport.example.ocp.database

import com.rsupport.example.ocp.interactor.FinancialDataGateway
import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class FinancialDataMapperTest{

    private lateinit var financialDatabase: FinancialDatabase

    @Before
    fun setup() {
        financialDatabase = FinancialDatabase()
    }

    @Test
    fun get() {
        financialDatabase.insert(0, "Rsupport", 1000)
        val financialDataGateway: FinancialDataGateway = FinancialDataMapper(financialDatabase)
        val financialEntity = financialDataGateway.get(0)
        assertThat("데이터를 찾지 못해서 실패", financialEntity, notNullValue())
    }

    @Test
    fun getAndCheckID() {
        financialDatabase.insert(0, "Rsupport", 1000)
        val financialDataGateway: FinancialDataGateway = FinancialDataMapper(financialDatabase)
        val financialEntity = financialDataGateway.get(0)
        assertThat("데이터를 찾지 못해서 실패", financialEntity?.id, `is`(0))
    }

    @Test
    fun getNotFound() {
        val financialDataGateway: FinancialDataGateway = FinancialDataMapper(financialDatabase)
        val financialEntity = financialDataGateway.get(0)
        assertThat("데이터가 없는데 데이터를 찾아서 실패", financialEntity, nullValue())
    }

}