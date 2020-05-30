package com.rsupport.example.ocp.printer.screen

import com.rsupport.example.ocp.controller.FinancialReportPresenter
import org.junit.Test
import org.mockito.Mockito

class ScreenPresenterTest{
    private val screenView = Mockito.mock(ScreenView::class.java)
    private val financialReportPresenter: FinancialReportPresenter = ScreenPresenter(screenView)

    @Test
    fun onReport() {
        financialReportPresenter.onReport(0, "Rsupport", 1000)
        Mockito.verify(screenView).onUpdate(ScreenViewModel(0, "Rsupport", 1000))
    }

    @Test
    fun onNotFound() {
        financialReportPresenter.onNotFound()
        Mockito.verify(screenView).onNotFoundFinancial()
    }
}