package com.rsupport.example.ocp.interactor

interface FinancialReportRequester {
    fun request(request: FinancialReportRequest): FinancialReportResponse?
}