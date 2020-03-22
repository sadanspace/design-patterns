package factory01.simpleFactory.RuleConfigV3;

import java.util.HashMap;
import java.util.Map;


public class RuleConfigParserFactory {

    private static Map<String, RuleConfigParser> RuleConfigParserMap = new HashMap<String, RuleConfigParser>();

    static {
        RuleConfigParserMap.put("json", new JsonRuleConfigParser());
        RuleConfigParserMap.put("xml", new XmlRuleConfigParser());
        RuleConfigParserMap.put("yaml", new YamlRuleConfigParser());
        RuleConfigParserMap.put("properties", new PropertiesRuleConfigParser());

    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()){
            return null;
        }
        IRuleConfigParser ruleConfigParser = RuleConfigParserMap.get(configFormat.toLowerCase());
        return ruleConfigParser;
    }
}
