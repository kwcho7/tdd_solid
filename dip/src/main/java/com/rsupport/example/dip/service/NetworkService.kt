package com.rsupport.example.dip.service

import com.rsupport.example.dip.application.Service
import com.rsupport.example.dip.application.message.Message

class NetworkService: Service {
    override fun write(message: Message): Boolean {
        // 데이터를 보내는것을 구현하면된다.
        return true
    }
}
