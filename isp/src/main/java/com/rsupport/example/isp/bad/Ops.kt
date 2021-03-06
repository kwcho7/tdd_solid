package com.rsupport.example.isp.bad

class OpsImpl: Ops {
    override fun op1(): String {
        val opNumber = 1
        return getResultOps(opNumber)
    }

    override fun op2(): String {
        val opNumber = 2
        return getResultOps(opNumber)
    }

    override fun op3(): String {
        val opNumber = 3
        return getResultOps(opNumber)
    }

    private fun getResultOps(opNumber: Int) = "result of op$opNumber"
}

interface Ops {
    fun op1(): String
    fun op2(): String
    fun op3(): String
}