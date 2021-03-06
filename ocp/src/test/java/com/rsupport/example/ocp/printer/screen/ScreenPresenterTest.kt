package com.rsupport.example.ocp.printer.screen

import com.rsupport.example.ocp.controller.FinancialReportPresenter
import com.rsupport.example.ocp.database.FinancialDatabase
import com.rsupport.example.ocp.di.financialModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.mockito.Mockito

class ScreenPresenterTest{
    private val screenView = Mockito.mock(ScreenView::class.java)
    private val financialReportPresenter: FinancialReportPresenter by lazy { ScreenPresenter(screenView) }

    private val financialDatabase = FinancialDatabase()

    @Before
    fun setup() {
        startKoin {
            modules(
                financialModule
            )
        }
        financialDatabase.clear()
    }

    @After
    fun tearDown() {
        stopKoin()
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