package com.rsupport.example.ocp.printer.print

import com.rsupport.example.ocp.controller.FinancialReportPresenter

class PrintPresenter(private val printView: PrintView) : FinancialReportPresenter {
    override fun onReport(id: Int, name: String, money: Long) {
        printView.onUpdate(PrintViewModel(id, name, money))
    }

    override fun onNotFound() {
        printView.onNotFoundFinancial()
    }
}