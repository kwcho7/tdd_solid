package com.rsupport.example.dip.service

import com.rsupport.example.dip.application.Service
import com.rsupport.example.dip.application.ServiceFactory

class NetworkServiceFactory : ServiceFactory {
    override fun create(): Service {
        return NetworkService()
    }

}
