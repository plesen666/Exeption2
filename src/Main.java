public class Main {

    public static void main(String[] args) {
        String login = "1234567890123456789_"; // Пример логина
        String password = "123456";           // Пример пароля
        String confirmPassword = "123456";    // Подтверждение пароля

//Обработка методов в блоке try/catch, который подтянет тебе все сообщения твоих кастомных исключений
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
            System.out.println("Регистрация успешна!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод валидации логина по всем требованиям ТЗ
    private static void validateLogin(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("ОШИБКА: У логина есть ограничение по длине – он должен быть равен или меньше 20 символов.");
        }
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("ОШИБКА: Логин должен содержать только латинские буквы, цифры и знак подчеркивания.");
        }
    }

    // Метод для валидации пароля по всем условиям ТЗ
    private static void validatePassword(String password, String confirmPassword) {
        if (password.length() > 20) {
            throw new WrongPasswordException("ОШИБКА: Пароль не должен превышать 20 символов.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("ОШИБКА: Пароли должны быть равны.");
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("ОШИБКА: Пароль должен содержать только латинские буквы, цифры и знак подчеркивания.");
        }
    }
}