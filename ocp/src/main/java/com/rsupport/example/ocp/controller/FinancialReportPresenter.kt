package com.rsupport.example.ocp.controller

interface FinancialReportPresenter {
    fun updateReport(id: Int)
    fun onReport(id: Int, name: String, money: Long)
    fun onNotFound()
}