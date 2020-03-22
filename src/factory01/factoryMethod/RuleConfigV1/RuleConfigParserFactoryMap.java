package factory01.factoryMethod.RuleConfigV1;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String ruleConfigFileExtention) {
        if (ruleConfigFileExtention == null || ruleConfigFileExtention.isEmpty()){
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(ruleConfigFileExtention.toLowerCase());
        return parserFactory;
    }
}
