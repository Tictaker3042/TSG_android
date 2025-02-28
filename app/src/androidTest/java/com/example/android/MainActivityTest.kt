package com.example.android

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Test
    fun testLogin() {
        // Запускаем EntryActivity
        ActivityScenario.launch(EntryActivity::class.java)

        // Проверяем, что поле для логина отображается
        onView(withId(R.id.loginEditText))
            .check(matches(isDisplayed()))

        // Проверяем, что поле для пароля отображается
        onView(withId(R.id.passwordEditText))
            .check(matches(isDisplayed()))

        // Проверяем, что кнопка входа отображается
        onView(withId(R.id.enter_button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testLoginFlow() {
        // Запускаем EntryActivity
        ActivityScenario.launch(EntryActivity::class.java)

        // Вводим логин и пароль
        onView(withId(R.id.loginEditText))
            .perform(typeText("administrator"), closeSoftKeyboard())
        onView(withId(R.id.passwordEditText))
            .perform(typeText("root"), closeSoftKeyboard())
        
        // Нажимаем кнопку входа
        onView(withId(R.id.enter_button))
            .perform(click())
    }

    @Test
    fun testNavigationBetweenScreens() {
        // Запускаем MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Проверяем наличие кнопки назад
        onView(withId(R.id.backButton))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    @Test
    fun testUtilityServicesNavigation() {
        // Запускаем MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Проверяем и нажимаем кнопку коммунальных услуг
        onView(withId(R.id.utility_indicators))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    @Test
    fun testPaymentsNavigation() {
        // Запускаем MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Проверяем и нажимаем кнопку платежей
        onView(withId(R.id.to_payments))
            .check(matches(isDisplayed()))
            .perform(click())
    }
} 