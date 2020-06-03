package com.rsupport.example.isp.bad

class User3(private val ops: Ops) {
    fun callOp3(): String {
        return ops.op3()
    }
}