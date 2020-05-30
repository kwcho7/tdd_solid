package com.rsupport.example.ocp.printer.print

import com.rsupport.example.ocp.controller.FinancialReportController
import com.rsupport.example.ocp.controller.FinancialReportPresenter
import com.rsupport.example.ocp.database.FinancialDataMapper
import com.rsupport.example.ocp.database.FinancialDatabase
import com.rsupport.example.ocp.interactor.FinancialReportGenerator

class PrintPresenter(private val printView: PrintView) : FinancialReportPresenter {
    private val financialReportController = FinancialReportController(
        FinancialReportGenerator(
            FinancialDataMapper(
                FinancialDatabase()
            )
        )
    ).apply {
        setFinancialReportPresenter(this@PrintPresenter)
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