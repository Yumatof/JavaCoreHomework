package Homework7.Enums;

public enum EnumsApi {
    API_KEY ("&appid=9289b9e923af5bfff57ca20ab5e6a133"),
    API_LINK ("http://api.openweathermap.org");

    private String value;

    EnumsApi(String value) {
        this.value = value;
        }
    public String getValue() {
        return value;
        }
    }