package com.rsupport.example.lsp.billing

class BusinessLicense(val baseFee: Int) : License {
    override fun calcFee(): Double {
        return baseFee * 2.0
    }
}