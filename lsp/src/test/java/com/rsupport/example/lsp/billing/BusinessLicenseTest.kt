package com.rsupport.example.lsp.billing

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class BusinessLicenseTest{

    @Test
    fun calcFee() {
        val baseFee = 100
        val license: License = BusinessLicense(baseFee)
        val calcFeeResult = license.calcFee()
        assertThat("Business Fee 가 달라서 실패", calcFeeResult, `is`(baseFee * 2.0))
    }
}