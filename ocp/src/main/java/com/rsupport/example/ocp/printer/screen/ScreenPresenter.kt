package com.rsupport.example.ocp.printer.screen

import com.rsupport.example.ocp.controller.FinancialReportPresenter

class ScreenPresenter(private var screenView: ScreenView): FinancialReportPresenter {

    override fun onReport(id: Int, name: String, money: Long) {
        screenView.onUpdate(ScreenViewModel(id, name, money))
    }

    override fun onNotFound() {
        screenView.onNotFoundFinancial()
    }

}