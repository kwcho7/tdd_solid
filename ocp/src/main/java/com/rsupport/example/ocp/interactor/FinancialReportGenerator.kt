package com.rsupport.example.ocp.interactor

class FinancialReportGenerator(private val financialDataGateway: FinancialDataGateway): FinancialReportRequester {
    override fun request(request: FinancialReportRequest): FinancialReportResponse? {
        return financialDataGateway.get(request.id)?.let {
            FinancialReportResponse(it.id, it.name, it.money)
        }
    }
}