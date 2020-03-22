package factory01.simpleFactory.RuleConfigV0;

/**
 * 根据配置文件的后缀名(.json、.xml、.yaml、.properties等)，
 * 选择不同的解析器(JsonRuleConfigParser、XmlRuleConfigParser、YamlRuleConfigParser、PropertiesRuleConfigParser等),
 * 将配置文件的数据解析到一个RuleConfig的对象中，以便统一使用
 */

public class RuleConfig {
    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtention = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new PropertiesRuleConfigParser();
        } else {
            throw new InvalidRuleConfigExtension(
                    "Rule config file format is not supported: " + ruleConfigFilePath
            );
        }

        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath){
        // ...解析文件名扩展名，例如rule.json，返回json
        return "json";
    }
}


