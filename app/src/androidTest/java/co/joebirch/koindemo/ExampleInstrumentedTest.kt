package co.joebirch.koindemo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import co.joebirch.koindemo.data.DataRepository
import co.joebirch.koindemo.model.Currency
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest: KoinTest {

    private val mockDataRepository = mock<DataRepository>()

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        loadKoinModules(module(override = true) {
            factory("local") { mockDataRepository }
        })
    }

    @Test
    fun activityLaunches() {
        activity.launchActivity(null)
        onView(withId(R.id.recycler_currencies))
                .check(matches(isDisplayed()))
    }

    @Test
    fun checkCurrenciesDisplay() {
        val currencies = CurrencyFactory.makeCurrencyList(5)
        stubDataRepositoryGetCurrencies(currencies)
        activity.launchActivity(null)

        checkCurrenciesAreDisplayed(currencies)
    }

    private fun checkCurrenciesAreDisplayed(currencies: List<Currency>) {
        currencies.forEachIndexed { index, currency ->
            onView(withId(R.id.recycler_currencies))
                    .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index))
            onView(RecyclerViewMatcher.withRecyclerView(R.id.recycler_currencies).atPosition(index))
                    .check(matches(hasDescendant(withText(currency.name))))
        }
    }

    private fun stubDataRepositoryGetCurrencies(currencies: List<Currency>) {
        whenever(mockDataRepository.getCurrencies(any()))
                .thenReturn(currencies)
    }
}
