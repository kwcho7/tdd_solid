package com.rsupport.example.lsp.billing

import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class PersonalLicenseTest{

    @Test
    fun calcFee() {
        val baseFee = 100
        val license: License = PersonalLicense(baseFee)
        val calcFeeResult = license.calcFee()
        assertThat("Personal fee 값이 달라서 실패", calcFeeResult, `is`(baseFee * 1.5))
    }
}