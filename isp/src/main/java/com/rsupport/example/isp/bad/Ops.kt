package com.rsupport.example.isp.bad

class Ops {
    fun op1(): String {
        val opNumber = 1
        return getResultOps(opNumber)
    }

    fun op2(): String {
        val opNumber = 2
        return getResultOps(opNumber)
    }

    fun op3(): String {
        val opNumber = 3
        return getResultOps(opNumber)
    }

    private fun getResultOps(opNumber: Int) = "result of op$opNumber"
}