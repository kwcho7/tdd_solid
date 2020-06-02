package com.rsupport.example.lsp.billing

import org.hamcrest.core.StringContains.containsString
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class BillingTest {
    private val baseFee = 100
    private val billing = Billing()

    @Test
    fun personalCalcFeeBilling() {
        val calcFeeResult = billing.calcFee(PersonalLicense(baseFee))
        assertThat("Personal 계산이 잘못되서 실패", calcFeeResult, containsString("150"))
    }

    @Test
    fun businessCalcFeeBilling() {
        val calcFeeResult = billing.calcFee(BusinessLicense(baseFee))
        assertThat("Personal 계산이 잘못되서 실패", calcFeeResult, containsString("200"))
    }
}