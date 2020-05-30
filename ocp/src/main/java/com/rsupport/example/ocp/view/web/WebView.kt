package com.rsupport.example.ocp.view.web

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.rsupport.example.ocp.R
import com.rsupport.example.ocp.controller.FinancialReportPresenter
import com.rsupport.example.ocp.printer.screen.ScreenPresenter
import com.rsupport.example.ocp.printer.screen.ScreenView
import com.rsupport.example.ocp.printer.screen.ScreenViewModel
import kotlinx.android.synthetic.main.fragment_webview.*

@Keep
class WebView: Fragment(), ScreenView {

    private val TAG: String = "WebView"
    private val financialReportPresenter: FinancialReportPresenter = ScreenPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onResume() {
        super.onResume()
        financialReportPresenter.updateReport(0)
    }

    override fun onUpdate(screenViewModel: ScreenViewModel) {
        financialTextView.text = Html.fromHtml(screenViewModel.toString())
    }

    override fun onNotFoundFinancial() {
        financialTextView.text = getString(R.string.not_found_financial)
    }
}