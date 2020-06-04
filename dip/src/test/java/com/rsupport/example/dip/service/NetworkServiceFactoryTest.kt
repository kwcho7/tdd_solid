package com.rsupport.example.dip.service

import com.rsupport.example.dip.application.ServiceFactory
import junit.framework.Assert.assertNotNull
import org.junit.Test

class NetworkServiceFactoryTest {

    @Test
    fun can_create() {
        val serviceFactory: ServiceFactory = NetworkServiceFactory()
        val service = serviceFactory.create()
        assertNotNull(service)
    }
}