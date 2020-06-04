package com.rsupport.example.dip.application

import com.rsupport.example.dip.application.message.Message

interface Service {
    fun write(message: Message): Boolean
}
