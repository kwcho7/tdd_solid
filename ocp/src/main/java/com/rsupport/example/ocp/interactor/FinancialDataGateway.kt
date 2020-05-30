package com.rsupport.example.ocp.interactor

interface FinancialDataGateway {
    fun get(key: Int): FinancialEntity?
}