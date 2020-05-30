package com.rsupport.example.ocp.controller

import com.rsupport.example.ocp.interactor.FinancialReportRequest
import com.rsupport.example.ocp.interactor.FinancialReportRequester

class FinancialReportController(private val financialReportRequester: FinancialReportRequester){

    private var financialReportPresenter: FinancialReportPresenter? = null

    fun setFinancialReportPresenter(financialReportPresenter: FinancialReportPresenter){
        this.financialReportPresenter = financialReportPresenter
    }

    fun updatePresent(id: Int) {
        financialReportRequester.request(FinancialReportRequest(id))?.let {
            financialReportPresenter?.onReport(it.id, it.name, it.money)
        } ?: financialReportPresenter?.onNotFound()
    }
}
