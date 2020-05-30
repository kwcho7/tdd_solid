package com.rsupport.example.ocp.database

import com.rsupport.example.ocp.interactor.FinancialDataGateway
import com.rsupport.example.ocp.interactor.FinancialEntity

class FinancialDataMapper(private val financialDatabase: FinancialDatabase) : FinancialDataGateway {
    override fun get(key: Int): FinancialEntity? {
        return financialDatabase.findById(key)?.let {
            FinancialEntity(it.id, it.name, it.money.toLong())
        }
    }
}