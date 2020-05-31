package com.rsupport.example.ocp.view.pdf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.rsupport.example.ocp.R
import com.rsupport.example.ocp.printer.print.PrintPresenter
import com.rsupport.example.ocp.printer.print.PrintView
import com.rsupport.example.ocp.printer.print.PrintViewModel
import kotlinx.android.synthetic.main.fragment_pdf_view.*

@Keep
class PDFView: Fragment(), PrintView {

    private val TAG: String = "PDFView"

    private val financialReportPresenter = PrintPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pdf_view, container, false)
    }

    override fun onResume() {
        super.onResume()
        financialReportPresenter.updateReport(0)
    }

    override fun onUpdate(printViewModel: PrintViewModel) {
        financialPdfTextView.text = "PDF".plus(" : ").plus(printViewModel.toString())
    }

    override fun onNotFoundFinancial() {
        financialPdfTextView.text = getString(R.string.not_found_financial)
    }
}