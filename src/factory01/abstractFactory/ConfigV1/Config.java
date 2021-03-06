package factory01.abstractFactory.ConfigV1;


/**
 * 在简单工厂、工厂方法中，类只有一种分类方式，也就是一种分类维度，当需要一个类可以hold住多种分类方式时，抽象工厂模式就派上用场。
 *
 * 例如：
 *  解析器类可以按照配置文件格式(.yaml、.xml等)来分类，也可以按照解析的对象类型(Rule规则配置还是System规则配置)来分类
 *
 *  就会存在以下8个类：
 *  针对规则配置的解析器：基于接口IRuleConfigParser
 *  JsonRuleConfigParser
 *  XmlRuleConfigParser
 *  YamlRuleConfigParser
 *  PropertiesRuleConfigParser
 *
 *  针对系统配置的解析器：基于接口ISystemConfigParser
 *  JsonSystemConfigParser
 *  XmlSystemConfigParser
 *  YamlSystemConfigParser
 *  PropertiesSystemConfigParser
 *
 *  原始版
 *
 *  迭代一：
 *  使用工厂方法模式进行封装
 *  此时添加一个新类型的配置文件，例如.ini，则需要添加四个类文件
 *  IniRuleConfigParser
 *  IniRuleConfigParserFactory
 *  IniSystemConfigParser
 *  IniSystemConfigParserFactory
 *  由于过多的类不好维护，所以使用抽象工厂模式减少这些类
 */

public class Config {
    public Config load(String ConfigFilePath, String type){

        String ConfigFileExtention = getFileExtension(ConfigFilePath);
        Object parser = null;

        if (type.equalsIgnoreCase("rule")) {
            parser = RuleConfigParserFactoryMap.getParserFactory(ConfigFileExtention).createParser();
            if (parser == null){
                throw new InvalidRuleConfigExtension(
                        "Rule config file format is not supported: " + ConfigFilePath
                );
            }
        } else if (type.equalsIgnoreCase("system")){
            parser = SystemConfigParserFactoryMap.getParserFactory(ConfigFileExtention).createParser();
            if (parser == null){
                throw new InvalidSystemConfigExtension(
                        "System config file format is not supported: " + ConfigFilePath
                );
            }
        } else {
            throw new InvalidConfigType(
                    "config type not supported: " + type
            );
        }

        String configText = "";
        Config config = parser.parse(configText);
        return config;
    }

    private String getFileExtension(String filePath){
        // ...解析文件名扩展名，例如rule.json，返回json
        return "json";
    }
}
