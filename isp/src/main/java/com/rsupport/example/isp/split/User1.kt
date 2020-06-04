package com.rsupport.example.isp.split

class User1(private val u1: U1Ops) {
    fun callOp1(): String {
        return u1.op1()
    }
}