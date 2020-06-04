package com.rsupport.example.dip.application

import com.rsupport.example.dip.application.message.Message

class DemoApplication(private val serviceFactory: ServiceFactory) {

    private lateinit var service: Service

    fun sendMessage(message: Message): Boolean {
        return writeMessage(message)
    }

    private fun writeMessage(message: Message): Boolean {
        if (!this::service.isInitialized) {
            service = this.serviceFactory.create()
        }
        return service.write(message)
    }
}
