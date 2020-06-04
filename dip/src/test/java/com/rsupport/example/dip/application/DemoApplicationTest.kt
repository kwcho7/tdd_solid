package com.rsupport.example.dip.application

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.rsupport.example.dip.application.message.Message
import junit.framework.Assert.assertTrue
import org.junit.Test

class DemoApplicationTest {
    private val message = Message(0, "hello")
    private val serviceFactory:ServiceFactory = mock()
    private val service: Service = mock()

    @Test
    fun verify_write_message() {
        given(serviceFactory.create()).willAnswer { service }
        given(service.write(message)).willAnswer { true }

        val application = DemoApplication().apply {
            this.setServiceFactory(serviceFactory)
        }
        val sendResult = application.sendMessage(message)

        verify(service).write(message)
        assertTrue(sendResult)
    }
}