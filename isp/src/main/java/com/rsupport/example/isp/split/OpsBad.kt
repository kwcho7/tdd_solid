package com.rsupport.example.isp.split

import com.rsupport.example.isp.bad.Ops

class OpsBad: Ops {
    override fun op1(): String {
        val opNumber = 1
        return getResultOps(opNumber)
    }

    override fun op2(): String {
        val opNumber = 2
        return getResultOps(opNumber)
    }


    override fun op3(): String {
        // ISP 원칙을 따르지 않았기 때문에 사용하지 않아도되는 op3 interface 를 구현해야한다.
        TODO("Not yet implemented")
    }

    private fun getResultOps(opNumber: Int) = "result of op$opNumber"
}