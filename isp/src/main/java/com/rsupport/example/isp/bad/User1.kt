package com.rsupport.example.isp.bad

class User1(private val ops: Ops) {
    fun callOp1(): String {
        return ops.op1()
    }
}