package com.example.tw3.glass.utility;

import com.example.tw3.glass.pages.permission.PermissionsGlassPage;
import com.example.tw3.glass.pages.permission.PermissionsJiraPage;
import com.example.tw3.glass.pages.permission.PermissionsPage;

import java.util.List;

public class PermissionUtility {
    PermissionsGlassPage glassPage = new PermissionsGlassPage();
    PermissionsJiraPage jiraPage = new PermissionsJiraPage();
    PermissionsPage currentPage;

    public boolean hasPermission(String task, String who) {
        List<String> permission = currentPage.getPermissions(task);
        for (String person : permission) {
            if (who.split(person).length > 1) { return true; }
        }
        return false;
    }
}
