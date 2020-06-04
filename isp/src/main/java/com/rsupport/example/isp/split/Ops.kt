package com.rsupport.example.isp.split

class Ops: U1Ops, U2Ops {
    override fun op1(): String {
        val opNumber = 1
        return getResultOps(opNumber)
    }

    override fun op2(): String {
        val opNumber = 2
        return getResultOps(opNumber)
    }

    private fun getResultOps(opNumber: Int) = "result of op$opNumber"
}