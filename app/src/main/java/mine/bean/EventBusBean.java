package mine.bean;

/**
 * Created by lenovo on 2017/11/13.
 */

public class EventBusBean {
    private String name;
    private String iconUrl;

    public EventBusBean(String name, String iconUrl) {
        this.name = name;
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public EventBusBean() {

    }
}
