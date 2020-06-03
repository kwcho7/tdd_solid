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

    // op1 의 결과만 수정하려면 user1 에서 사용하지 않는 op2,op3 도 영향을 받는다.
    private fun getResultOps(opNumber: Int) = "result of op$opNumber"
}