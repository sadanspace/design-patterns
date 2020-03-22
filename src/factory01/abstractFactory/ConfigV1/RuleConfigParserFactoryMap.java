package factory01.abstractFactory.ConfigV1;

import java.util.HashMap;
import java.util.Map;


public class RuleConfigParserFactoryMap {
    public static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String ruleConfigFileExtension){
        if (ruleConfigFileExtension.isEmpty() || ruleConfigFileExtension == null){
            return null;
        }

        IRuleConfigParserFactory parserFactory = cachedFactories.get(ruleConfigFileExtension);
        return parserFactory;

    }

}
