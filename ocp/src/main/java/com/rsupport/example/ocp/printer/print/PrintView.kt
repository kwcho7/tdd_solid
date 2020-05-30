package com.rsupport.example.ocp.printer.print

interface PrintView {
    fun onUpdate(printViewModel: PrintViewModel)
    fun onNotFoundFinancial()
}