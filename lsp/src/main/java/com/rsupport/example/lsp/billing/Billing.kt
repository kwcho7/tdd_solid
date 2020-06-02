package com.rsupport.example.lsp.billing

class Billing {

    fun calcFee(license: License): String {
        return """
            fee : $${license.calcFee()}
        """.trimIndent()
    }
}