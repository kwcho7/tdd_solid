package com.rsupport.example.ocp.printer.screen

import com.rsupport.example.ocp.controller.FinancialReportPresenter
import com.rsupport.example.ocp.database.FinancialDatabase
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ScreenPresenterTest{
    private val screenView = Mockito.mock(ScreenView::class.java)
    private val financialReportPresenter: FinancialReportPresenter = ScreenPresenter(screenView)

    private val financialDatabase = FinancialDatabase()

    @Before
    fun setup() {
        financialDatabase.clear()
    }

    @Test
    fun onReport() {
        financialDatabase.insert(0, "Rsupport", 1000)

        financialReportPresenter.updateReport(0)
        Mockito.verify(screenView).onUpdate(ScreenViewModel(0, "Rsupport", 1000))
    }

    @Test
    fun onNotFound() {
        financialReportPresenter.updateReport(0)
        Mockito.verify(screenView).onNotFoundFinancial()
    }
}