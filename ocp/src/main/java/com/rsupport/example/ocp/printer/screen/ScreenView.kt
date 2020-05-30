package com.rsupport.example.ocp.printer.screen

interface ScreenView {
    fun onUpdate(screenViewModel: ScreenViewModel)
    fun onNotFoundFinancial()
}