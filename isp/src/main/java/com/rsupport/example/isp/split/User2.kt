package com.rsupport.example.isp.split

class User2(private val u2Ops: U2Ops) {
    fun callOp2(): String {
        return u2Ops.op2()
    }
}