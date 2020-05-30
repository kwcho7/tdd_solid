package com.rsupport.example.ocp.database

class FinancialDatabase {
    companion object{
        private val companyMap = mutableMapOf<Int, Company>()
    }

    fun clear() {
        companyMap.clear()
    }

    fun insert(id: Int, name: String, money: Int): Boolean {
        if(hasCompany(id)) return false
        companyMap[id] = Company(id, name, money)
        return true
    }

    fun delete(id: Int): Boolean {
        return companyMap.remove(id)?.let { true } ?: false
    }

    private fun hasCompany(id: Int) = companyMap.containsKey(id)

    fun findById(id: Int): Company? {
        return companyMap[id]
    }

    data class Company(val id: Int, val name: String, val money: Int)
}