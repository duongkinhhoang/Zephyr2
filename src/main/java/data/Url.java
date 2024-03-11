package data;

public enum Url {
    URL_LOGIN("https://opensource-demo.orangehrmlive.com/"),
    URL_VIEWSYSTEMUSER("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}

