Для запуска данного консольного приложения необходимо в консоле прописать следующую комманду:
java -jar *путь к фалу*\mgts-1.0-SNAPSHOT.jar

Все дополнительные задачи выполнены:
1. Сохранение и загрузка данных
2. Валлидация номера пропуска (так как в моделе Person отстствует поле "номер телефона" - валидация номер отсутствует)

 Структура программы:
 Класс Main считается отпровной точкой программы.
 Для более структурированного кода было принято решение создать статический метод variator для обработки выбранных пользователем вариантов. Сам класс ScenarioVAriator напоминает патерн "фабрика".
 Для реализации логики вариантов был выюран патерн "стратегия"
 Работу по обработке выбранного сценария берет на себя класс DataManager.
