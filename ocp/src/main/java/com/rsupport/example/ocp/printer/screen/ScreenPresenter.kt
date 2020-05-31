package com.rsupport.example.ocp.printer.screen

import com.rsupport.example.ocp.controller.FinancialReportController
import com.rsupport.example.ocp.controller.FinancialReportPresenter
import org.koin.java.KoinJavaComponent.inject

class ScreenPresenter(private var screenView: ScreenView): FinancialReportPresenter {
    private val financialReportController by inject(FinancialReportController::class.java).apply {
        value.setFinancialReportPresenter(this@ScreenPresenter)
    }

    override fun updateReport(id: Int) {
        financialReportController.updatePresent(id)
    }

    override fun onReport(id: Int, name: String, money: Long) {
        screenView.onUpdate(ScreenViewModel(id, name, money))
    }

    override fun onNotFound() {
        screenView.onNotFoundFinancial()
    }

}