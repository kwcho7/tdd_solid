package com.rsupport.example.ocp.interactor

import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class FinancialReportGeneratorTest{

    private val mockFinancialDataGateway = Mockito.mock(FinancialDataGateway::class.java)
    private lateinit var financialReportGenerator: FinancialReportRequester

    @Before
    fun setup() {
        financialReportGenerator = FinancialReportGenerator(mockFinancialDataGateway)
    }

    @Test
    fun request() {
        `when`(mockFinancialDataGateway.get(0)).thenReturn(FinancialEntity(0, "Rsupport", 1000))

        val financialResponse = financialReportGenerator.request(FinancialReportRequest(0))
        assertThat("찾은 재무정보 회사 id 가 달라서 실패", financialResponse?.id, `is`(0))
    }

    @Test
    fun requestNotFound() {
        `when`(mockFinancialDataGateway.get(0)).thenReturn(null)
        val financialResponse = financialReportGenerator.request(FinancialReportRequest(0))
        assertThat("데이터가 없을때 데이터를 찾아서 실패", financialResponse, nullValue())
    }
}