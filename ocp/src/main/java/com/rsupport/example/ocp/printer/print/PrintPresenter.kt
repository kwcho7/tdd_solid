package com.rsupport.example.ocp.printer.print

import com.rsupport.example.ocp.controller.FinancialReportController
import com.rsupport.example.ocp.controller.FinancialReportPresenter
import org.koin.java.KoinJavaComponent.inject

class PrintPresenter(private val printView: PrintView) : FinancialReportPresenter {
    private val financialReportController by inject(FinancialReportController::class.java)
        .apply {
            value.setFinancialReportPresenter(this@PrintPresenter)
        }

    override fun updateReport(id: Int) {
        financialReportController.updatePresent(id)
    }

    override fun onReport(id: Int, name: String, money: Long) {
        printView.onUpdate(PrintViewModel(id, name, money))
    }

    override fun onNotFound() {
        printView.onNotFoundFinancial()
    }
}