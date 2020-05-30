package com.rsupport.example.ocp.controller

import com.rsupport.example.ocp.database.FinancialDataMapper
import com.rsupport.example.ocp.database.FinancialDatabase
import com.rsupport.example.ocp.interactor.FinancialReportGenerator
import com.rsupport.example.ocp.interactor.FinancialReportRequester
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class FinancialReportControllerTest{

    private val financialReportPresenter = Mockito.mock(FinancialReportPresenter::class.java)
    private lateinit var financialReportRequester: FinancialReportRequester
    private lateinit var financialDatabase: FinancialDatabase

    @Before
    fun setup() {
        financialDatabase = FinancialDatabase()
        financialDatabase.insert(0, "Rsupport", 1000)
        financialReportRequester = FinancialReportGenerator(
            FinancialDataMapper(financialDatabase)
        )
    }

    @Test
    fun findReport(){
        val financialReportController = FinancialReportController(financialReportRequester).apply {
            setFinancialReportPresenter(financialReportPresenter)
        }
        financialReportController.updatePresent(0)
        Mockito.verify(financialReportPresenter).onReport(0, "Rsupport", 1000)
    }

    @Test
    fun findReportNotFound() {
        val financialReportController = FinancialReportController(financialReportRequester).apply {
            setFinancialReportPresenter(financialReportPresenter)
        }
        financialReportController.updatePresent(1)
        Mockito.verify(financialReportPresenter).onNotFound()
    }
}