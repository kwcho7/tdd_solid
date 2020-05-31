package com.rsupport.example.ocp.view.pdf

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.rsupport.example.ocp.R
import com.rsupport.example.ocp.activities.pdf.PDFViewActivity
import com.rsupport.example.ocp.database.FinancialDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class PDFViewTest{

    private val financialDatabase = FinancialDatabase()
    private lateinit var context: Context


    @Before
    fun setup() {
        financialDatabase.clear()
        context = InstrumentationRegistry.getInstrumentation().targetContext

    }

    @Test
    fun pdfFinancialDisplay() = runBlocking<Unit> {
        financialDatabase.insert(0, "Rsupport", 1000)
        ActivityScenario.launch(PDFViewActivity::class.java)

        onView(withId(R.id.financialPdfTextView)).check(matches(withSubstring("PDF")))
    }

    @Test
    fun notFoundDisplay() = runBlocking<Unit> {
        ActivityScenario.launch(PDFViewActivity::class.java)

        onView(withId(R.id.financialPdfTextView)).check(matches(withText(context.getString(R.string.not_found_financial))))
    }
}