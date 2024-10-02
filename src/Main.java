public class Main {


    public static void main(String[] args) {
        String login = "1234567890123456789_";
        String password = "123456";
        String confirmPassword = "123456";
        if (login.length() > 20) {
            throw new WrongLoginException("ОШИБКА.У логина есть ограничение по длине – он должен быть равен или меньше 20 символов");
        }
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException(" ОШИБКА.Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException(" ОШИБКА. Пароль длиннее 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException(" ОШИБКА. Пароли  должны быть равны.");
        }
        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                throw new WrongPasswordException(" ОШИБКА.Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания.");
            }
        }
    }
}
