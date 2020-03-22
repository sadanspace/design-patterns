package factory01.simpleFactory.RuleConfigV3;

/**
 * 根据配置文件的后缀名(.json、.xml、.yaml、.properties等)，
 * 选择不同的解析器(JsonRuleConfigParser、XmlRuleConfigParser、YamlRuleConfigParser、PropertiesRuleConfigParser等),
 * 将配置文件的数据解析到一个RuleConfig的对象中，以便统一使用
 *
 * 迭代一:
 * 将独立功能的模块封装成函数，将创建IRuleConfigParser对象的功能抽取成一个函数
 *
 * 迭代二:
 * 基于单一职责原则，将和该类无关的createParser方法单独剥离出来，构建为一个专门创建Parser的类，此类为简单工厂模式类
 *
 * 迭代三:
 * 简单工厂模式类，每次调用createParser方法，都会创建一个新的Parser对象，但是这些对象是可以重用的，不需要每次创建新的。
 * 所以可以将其放置提前放置内存中，更加高效的获取。
 */

public class RuleConfig {
    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtention = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtention);
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
}

