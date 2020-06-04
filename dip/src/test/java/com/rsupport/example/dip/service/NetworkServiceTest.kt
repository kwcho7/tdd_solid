package com.rsupport.example.dip.service

import com.rsupport.example.dip.application.Service
import com.rsupport.example.dip.application.message.Message
import junit.framework.Assert.assertTrue
import org.junit.Test

class NetworkServiceTest {

    @Test
    fun can_write() {
        val service:Service = NetworkService()
        val writeResult = service.write(Message(0, "hello"))
        assertTrue(writeResult)
    }
}