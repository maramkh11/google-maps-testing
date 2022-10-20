package web.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import web.utils.PropertyReader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebsiteProperty {

    public static final String URL;

    static {
        PropertyReader setupProperties = new PropertyReader("config.properties");
        URL = setupProperties.readItem("url");
    }

}
