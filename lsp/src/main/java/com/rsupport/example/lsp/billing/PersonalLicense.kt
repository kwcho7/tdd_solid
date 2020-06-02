package com.rsupport.example.lsp.billing

class PersonalLicense(private val baseFee: Int) : License {
    override fun calcFee(): Double {
        return baseFee * 1.5
    }
}