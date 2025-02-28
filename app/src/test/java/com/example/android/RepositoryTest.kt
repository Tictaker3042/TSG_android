package com.example.android

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryTest {

    @Test
    fun testLoginUser() = runTest {
        // Arrange
        val testService = TestService()
        val repository = Repository(testService)

        // Добавляем тестового пользователя
        val userData = UserData(
            amount = "100",
            cold_water = "50",
            document_number = "12345",
            electricity_day = "30",
            electricity_night = "20",
            hot_water = "40",
            owner = "John Doe",
            room_number = 101,
            transfer_date = "2023-10-01",
            last_payment_date = "2023-09-01"
        )
        testService.usersList.add(userData)

        // Act
        repository.loginUser("12345", "100")

        // Assert
        // Если исключение не выброшено, тест считается успешным
    }

    @Test
    fun testGetProductByRoomNumber() = runTest {
        // Arrange
        val testService = TestService()
        val repository = Repository(testService)

        // Добавляем тестовые данные
        val utilityData = UserData(
            amount = "100",
            cold_water = "50",
            document_number = "12345",
            electricity_day = "30",
            electricity_night = "20",
            hot_water = "40",
            owner = "John Doe",
            room_number = 101,
            transfer_date = "2023-10-01",
            last_payment_date = "2023-09-01"
        )
        testService.utilitiesList.add(utilityData)

        // Act
        val products = repository.getProduct(101)

        // Assert
        assertEquals(1, products.size)
        assertEquals(101, products[0].room_number)
    }

    @Test
    fun testGetInfo() = runTest {
        // Arrange
        val testService = TestService()
        val repository = Repository(testService)

        // Добавляем тестовые данные
        val paymentData = UserData(
            amount = "100",
            cold_water = "50",
            document_number = "12345",
            electricity_day = "30",
            electricity_night = "20",
            hot_water = "40",
            owner = "John Doe",
            room_number = 101,
            transfer_date = "2023-10-01",
            last_payment_date = "2023-09-01"
        )
        testService.paymentsList.add(paymentData)

        // Act
        val payments = repository.getInfo()

        // Assert
        assertEquals(1, payments.size)
        assertEquals(101, payments[0].room_number)
    }

    @Test
    fun testGetInfoByRoomNumber() = runTest {
        // Arrange
        val testService = TestService()
        val repository = Repository(testService)

        // Добавляем тестовые данные
        val paymentData = UserData(
            amount = "100",
            cold_water = "50",
            document_number = "12345",
            electricity_day = "30",
            electricity_night = "20",
            hot_water = "40",
            owner = "John Doe",
            room_number = 101,
            transfer_date = "2023-10-01",
            last_payment_date = "2023-09-01"
        )
        testService.paymentsList.add(paymentData)

        // Act
        val payments = repository.getInfo(101)

        // Assert
        assertEquals(1, payments.size)
        assertEquals(101, payments[0].room_number)
    }
}