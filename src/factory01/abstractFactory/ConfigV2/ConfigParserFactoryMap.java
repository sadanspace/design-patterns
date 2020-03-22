package factory01.abstractFactory.ConfigV2;

import java.util.HashMap;
import java.util.Map;


public class ConfigParserFactoryMap {
    public static final Map<String, IConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonConfigParserFactory());
        cachedFactories.put("yaml", new YamlConfigParserFactory());
        cachedFactories.put("xml", new XmlConfigParserFactory());
        cachedFactories.put("properties", new PropertiesConfigParserFactory());
    }

    public static IConfigParserFactory getParserFactory(String ruleConfigFileExtension){
        if (ruleConfigFileExtension.isEmpty() || ruleConfigFileExtension == null){
            return null;
        }

        IConfigParserFactory parserFactory = cachedFactories.get(ruleConfigFileExtension);
        return parserFactory;

    }

}
