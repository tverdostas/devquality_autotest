package enums;

public enum MiddleMenu {
    TARIFFS("Тарифы"),
    SERVICES_AND_OPTIONS("Услуги и опции"),
    HOME_INTERNET("Домашний интернет"),
    DOWNLOAD_MY_MTS("Скачать Мой МТС"),
    PREMIUM("Premium"),
    ROAMING("Роуминг"),
    FAMILY_GROUP("Семейная группа"),
    MONEY("Деньги"),
    PROMOTIONS("Акции");

    private final String displayName;

    MiddleMenu(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
