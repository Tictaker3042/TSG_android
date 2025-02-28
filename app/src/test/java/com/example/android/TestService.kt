package com.example.android

class TestService : UserService {

    // Список для хранения данных о пользователях
    val usersList = mutableListOf<UserData>()

    // Список для хранения данных о коммунальных услугах
    val utilitiesList = mutableListOf<UserData>()

    // Список для хранения данных о последних платежах
    val paymentsList = mutableListOf<UserData>()

    override suspend fun loginUser(loginData: LoginData) {
        // Проверяем, существует ли пользователь в списке
        val userExists = usersList.any { it.document_number == loginData.username && it.amount == loginData.password }
        if (!userExists) {
            throw Exception("Пользователь не найден")
        }
    }

    override suspend fun getProduct(): List<UserData> {
        // Возвращаем список всех коммунальных услуг
        return utilitiesList
    }

    override suspend fun getProduct(roomNumber: Int): List<UserData> {
        // Возвращаем данные для конкретной комнаты
        return utilitiesList.filter { it.room_number == roomNumber }
    }

    override suspend fun getInfo(): List<UserData> {
        // Возвращаем список последних платежей
        return paymentsList
    }

    override suspend fun getInfo(roomNumber: Int): List<UserData> {
        // Возвращаем данные о платежах для конкретной комнаты
        return paymentsList.filter { it.room_number == roomNumber }
    }
}