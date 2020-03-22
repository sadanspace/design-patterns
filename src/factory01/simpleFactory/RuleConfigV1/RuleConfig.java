package factory01.simpleFactory.RuleConfigV1;

/**
 * 根据配置文件的后缀名(.json、.xml、.yaml、.properties等)，
 * 选择不同的解析器(JsonRuleConfigParser、XmlRuleConfigParser、YamlRuleConfigParser、PropertiesRuleConfigParser等),
 * 将配置文件的数据解析到一个RuleConfig的对象中，以便统一使用
 *
 * 迭代一:
 * 将独立功能的模块封装成函数，将创建IRuleConfigParser对象的功能抽取成一个函数
 */

public class RuleConfig {
    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtention = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParser(ruleConfigFileExtention);
        if (parser == null){
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

    private IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtention)){
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}


