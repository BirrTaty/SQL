package netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import netology.data.DB;
import netology.data.DBUser;
import netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static netology.data.DB.deleteCode;

public class DBTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void cleanDB() {
        deleteCode();
    }

    @Test
    void shouldEnterInPersonalAccount() {
        var loginPage = new LoginPage();
        var verificationPage = loginPage.validLogin(DBUser.getUser());
        var dashboardPage = verificationPage.validVerify(DB.getCode());
        assertEquals("Личный кабинет", dashboardPage.getAccount());
    }
}