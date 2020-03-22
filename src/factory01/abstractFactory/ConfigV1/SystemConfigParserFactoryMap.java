package factory01.abstractFactory.ConfigV1;

import java.util.HashMap;
import java.util.Map;

public class SystemConfigParserFactoryMap {
    public static final Map<String, ISystemConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonSystemConfigParserFactory());
        cachedFactories.put("yaml", new YamlSystemConfigParserFactory());
        cachedFactories.put("xml", new XmlSystemConfigParserFactory());
        cachedFactories.put("properties", new PropertiesSystemConfigParserFactory());
    }

    public static ISystemConfigParserFactory getParserFactory(String systemConfigFileExtension){
        if (systemConfigFileExtension.isEmpty() || systemConfigFileExtension == null){
            return null;
        }

        ISystemConfigParserFactory parserFactory = cachedFactories.get(systemConfigFileExtension);
        return parserFactory;
    }
}
