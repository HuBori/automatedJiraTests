package com.example.tw3.glass.pages.permission;

import java.util.List;

public abstract class PermissionsPage {
    public abstract String getUrl();
    public abstract List<String> getPermissions(String task);
}
