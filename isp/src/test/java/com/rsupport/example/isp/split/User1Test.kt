package com.rsupport.example.isp.split

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class User1Test{

    @Test
    fun return_string_when_called_op1() {
        val ops = Ops()
        val user1 = User1(ops)
        val callOp1Result = user1.callOp1()
        assertThat(callOp1Result, `is`("result of op1"))
    }
}

