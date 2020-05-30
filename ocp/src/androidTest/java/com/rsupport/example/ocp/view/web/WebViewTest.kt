package com.rsupport.example.ocp.view.web

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSubstring
import androidx.test.platform.app.InstrumentationRegistry
import com.rsupport.example.ocp.R
import com.rsupport.example.ocp.activities.web.WebViewActivity
import com.rsupport.example.ocp.database.FinancialDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class WebViewTest{

    private val financialDatabase = FinancialDatabase()
    private lateinit var context: Context

    @Before
    fun setup() {
        financialDatabase.clear()
        context = InstrumentationRegistry.getInstrumentation().targetContext

    }

    @Test
    fun financialDisplay() = runBlocking<Unit>{
        ActivityScenario.launch(WebViewActivity::class.java)
        financialDatabase.insert(0, "Rsupport", 1000)

        onView(withId(R.id.financialTextView))
            .check(matches(withSubstring("Rsupport")))

        onView(withId(R.id.financialTextView))
            .check(matches(withSubstring("1000")))
    }

    @Test
    fun notFoundDisplay() = runBlocking<Unit> {
        ActivityScenario.launch(WebViewActivity::class.java)
        onView(withId(R.id.financialTextView))
            .check(matches(withSubstring(context.getString(R.string.not_found_financial))))
    }
}