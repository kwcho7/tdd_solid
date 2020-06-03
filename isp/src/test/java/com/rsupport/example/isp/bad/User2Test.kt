package com.rsupport.example.isp.bad

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class User2Test{

    private val ops = Ops()

    @Test
    fun can_create_user2() {
        val user2 = User2(ops)
        val callOp2Result = user2.callOp2()
        assertThat(callOp2Result, `is`("result of op2"))
    }
}