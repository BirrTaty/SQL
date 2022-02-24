package netology.page;

import com.codeborne.selenide.SelenideElement;
import netology.data.DBUser;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id='login'] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DBUser.User user) {
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}