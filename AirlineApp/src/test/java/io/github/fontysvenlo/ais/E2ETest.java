package io.github.fontysvenlo.ais;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.VncRecordingContainer.VncRecordingFormat;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class IntegratedUITest {
    @Container
    public BrowserWebDriverContainer<?> browser = new BrowserWebDriverContainer<>()
        .withCapabilities(new ChromeOptions())
        .withRecordingMode(VncRecordingMode.RECORD_FAILING, new File("target"), VncRecordingFormat.MP4);

    @Container
    private PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>("postgres:latest")
        .withDatabaseName("airline_db")
        .withUsername("user")
        .withPassword("secret")
        .withInitScript("test_db.sql");

    private static Thread serverThread;

    // TODO: decide: we run in a container instead - or at least at a non-default port
    @BeforeAll
    static void startServer() {
        serverThread = new Thread(() -> {
            try {
                App.main(new String[] {});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        // So that the browser can access the server:
        org.testcontainers.Testcontainers.exposeHostPorts(8001);
    }

    @AfterAll
    static void stopServer() {
        serverThread.interrupt();
    }

    @Test
    void testOpeningHomePage() {
        RemoteWebDriver driver = new RemoteWebDriver(browser.getSeleniumAddress(), new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://host.testcontainers.internal:8001/index.html");
        WebElement titleElement = driver.findElement(By.tagName("body"));
        assertThat(titleElement.getText()).contains("Welcome to Fontys Airlines");
    }
}
