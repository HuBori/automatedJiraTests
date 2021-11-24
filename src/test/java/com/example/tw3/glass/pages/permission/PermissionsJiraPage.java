package com.example.tw3.glass.pages.permission;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class PermissionsJiraPage extends PermissionsPage {
    private String url = "https://jira-auto.codecool.metastage.net/plugins/servlet/project-config/PP/permissions";

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public List<String> getPermissions(String task) {
        SelenideElement field = $x("//td/p[text()='" + task + "']/..//following-sibling::td");
        List<WebElement> permissionElements = field.findElements(By.xpath("//dl[@class='types']//dt[@class='sentence-case']"));
        List<String> permissions = new ArrayList<>();
        for (WebElement el : permissionElements) {
            permissions.add(el.getText());
        }
        return permissions;
    }
}
