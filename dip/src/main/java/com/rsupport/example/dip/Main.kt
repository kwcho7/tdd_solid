package com.rsupport.example.dip

import com.rsupport.example.dip.application.DemoApplication
import com.rsupport.example.dip.application.message.Message
import com.rsupport.example.dip.service.NetworkServiceFactory

class Main {

    companion object{
        @JvmStatic
        fun main(vararg args: String){
            val demoApplication = DemoApplication(NetworkServiceFactory())
            demoApplication.sendMessage(Message(0, "hello"))
        }
    }
}