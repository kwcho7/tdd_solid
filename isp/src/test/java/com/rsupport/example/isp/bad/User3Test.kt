package com.rsupport.example.isp.bad

import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Test

class User3Test{

    private val ops = Ops()

    @Test
    fun return_value_when_called_op3() {
        val user3 = User3(ops)
        val callOp3Result = user3.callOp3()
        assertThat(callOp3Result, `is`("result of op3"))
    }
}