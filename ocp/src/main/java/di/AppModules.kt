package di

import com.rsupport.example.ocp.controller.FinancialReportController
import com.rsupport.example.ocp.database.FinancialDataMapper
import com.rsupport.example.ocp.database.FinancialDatabase
import com.rsupport.example.ocp.interactor.FinancialDataGateway
import com.rsupport.example.ocp.interactor.FinancialReportGenerator
import com.rsupport.example.ocp.interactor.FinancialReportRequester
import org.koin.dsl.module

val financialModule = module{
    single { FinancialDatabase() }
    factory<FinancialDataGateway> { FinancialDataMapper(get()) }
    factory<FinancialReportRequester> { FinancialReportGenerator(get()) }
    factory { FinancialReportController(get()) }
}
