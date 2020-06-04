package com.rsupport.example.dip.application

import com.rsupport.example.dip.application.message.Message

class DemoApplication {

    private lateinit var service: Service
    private lateinit var serviceFactory: ServiceFactory

    fun sendMessage(message: Message): Boolean {
        return writeMessage(message)
    }

    private fun writeMessage(message: Message): Boolean {
        if (!this::service.isInitialized) {
            service = serviceFactory.create()
        }
        return service.write(message)
    }

    fun setServiceFactory(serviceFactory: ServiceFactory) {
        this.serviceFactory = serviceFactory
    }
}
