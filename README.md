# Chronos 🕒

**Chronos** — это кроссплатформенное приложение-планнер, написанное на **Kotlin Multiplatform** с использованием **JetBrains Compose Multiplatform**, поддерживающее Android, iOS и Desktop.
Сыылка на ноушен https://l3on1kl.notion.site/Chronos-working-title-1e75f5a32b9f806db152c837eab435af

## ✨ Возможности

- ✅ Создание задач с дедлайнами
- 📅 Просмотр расписания
- ⏰ Напоминания
- 🔄 Синхронизация между устройствами
- ☁️ Firebase Firestore (offline-first)
- 💡 MVI-архитектура + Clean Architecture

---

## 🧱 Архитектура

- `core`: общая инфраструктура (лог, сеть, база, синхронизация)
- `feature:*`: бизнес-логика (например, `tasks`, `calendar`)
- `composeApp`: общий UI на Compose Multiplatform
- `:androidApp`, `:iosApp`, `:desktopApp`: платформенные врапперы

---

## 🧪 CI/CD

![CI](https://github.com/Koynovigor/Chronos/actions/workflows/ci.yml/badge.svg)

Автоматические проверки:

- ✅ Сборка проекта
- 🧪 Unit-тесты (`:test:shared`)
- 🔍 Статический анализ (`detekt`, `ktlint`)

---

## 🚀 Стек

| Область          | Технологии                             |
|------------------|----------------------------------------|
| UI               | Compose Multiplatform 1.8.0            |
| Архитектура      | MVI + Clean Architecture               |
| DI               | Koin                                   |
| Сеть             | Ktor                                   |
| База данных      | SQLDelight                             |
| Firebase         | Firestore, Cloud Messaging             |
| Тестирование     | Kotlin Test, Turbine                   |
| CI               | GitHub Actions                         |

---

## 📦 Сборка проекта

```bash
./gradlew build
./gradlew allTests
./gradlew detekt
./gradlew ktlintCheck
