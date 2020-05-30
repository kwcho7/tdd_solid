package com.rsupport.example.ocp.printer.screen

import com.rsupport.example.ocp.controller.FinancialReportController
import com.rsupport.example.ocp.controller.FinancialReportPresenter
import com.rsupport.example.ocp.database.FinancialDataMapper
import com.rsupport.example.ocp.database.FinancialDatabase
import com.rsupport.example.ocp.interactor.FinancialReportGenerator

class ScreenPresenter(private var screenView: ScreenView): FinancialReportPresenter {
    private val financialReportController = FinancialReportController(
        FinancialReportGenerator(
            FinancialDataMapper(
                FinancialDatabase()
            )
        )
    ).apply {
        setFinancialReportPresenter(this@ScreenPresenter)
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