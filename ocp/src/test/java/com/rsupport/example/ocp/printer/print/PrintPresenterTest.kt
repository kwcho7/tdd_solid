package com.rsupport.example.ocp.printer.print

import com.rsupport.example.ocp.controller.FinancialReportPresenter
import org.junit.Test
import org.mockito.Mockito

class PrintPresenterTest{
    private val printView = Mockito.mock(PrintView::class.java)
    private val financialReportPresenter: FinancialReportPresenter = PrintPresenter(printView)


    @Test
    fun onReport() {
        financialReportPresenter.onReport(0, "Rsupport", 1000)
        Mockito.verify(printView).onUpdate(PrintViewModel(0, "Rsupport", 1000))
    }

    @Test
    fun onNotFound() {
        financialReportPresenter.onNotFound()
        Mockito.verify(printView).onNotFoundFinancial()
    }
}