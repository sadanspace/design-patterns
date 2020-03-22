package factory01.factoryMethod.RuleConfigV0;

import java.util.Properties;

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
 *
 * 以上为简单工厂模式
 * ---
 * 以下为工厂方法模式
 *
 * 迭代一:
 *  去掉if判断，使用多态的方式，用一个ParserFactory接口，具体的Parser实现，每次新增一种文件类型，只需要添加一个新的Parser实现
 *  但此方法没有完全解决if的判断逻辑，还和最原始的版本类似
 *
 */

public class RuleConfig {
    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtention = getFileExtension(ruleConfigFilePath);


        IRuleConfigParserFactory parserFactory = null;

        if (ruleConfigFileExtention.equals("json")){
            parserFactory = new JsonRuleConfigParserFactory();
        } else if (ruleConfigFileExtention.equals("xml")){
            parserFactory = new XmlRuleConfigParserFactory();
        } else if (ruleConfigFileExtention.equals("yaml")){
            parserFactory = new YamlRuleConfigParserFactory();
        } else if (ruleConfigFileExtention.equals("properties")){
            parserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            throw new InvalidRuleConfigExtension(
                    "Rule config file format is not supported: " + ruleConfigFilePath
            );
        }

        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath){
        // ...解析文件名扩展名，例如rule.json，返回json
        return "json";
    }
}

