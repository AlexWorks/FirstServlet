package ua.kpi.tef.controller;

public interface RegularExpressions {
    String UA_NAME_REGEXP = "(?u)^[А-ЯІЇЄ][а-яіїє]*'?[а-яіїє]+";
    String EMAIL_REGEXP = "(?iu)^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    String LOGIN_REGEXP = "(?iu)^[a-z0-9_-]{3,15}$";
}
