package com.rsupport.example.isp.bad

class User2(private val ops: Ops) {
    fun callOp2(): String {
        return ops.op2()
    }


}