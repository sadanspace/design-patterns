package factory01.factoryMethod.RuleConfigV1;

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
 *  但此方法没有完全解决if的判断逻辑，还和最原始的版本类似（此方式比简单工厂模式更加符合 开闭原则）
 *
 * 迭代二:
 *  为了解决第一版的if判断逻辑，可以为工厂类再创建一个简单工厂，一个用来创建工厂的工厂类。
 *  此时在新增一种文件类型时，只需要添加Parser、ParserFactory以及在cachedFactories添加映射关系即可，代码改动少，基本符合开闭原则。
 *  但是增加了代码修改的复杂性，每个ParserFactory功能非常单薄（只有一行代码），这种情况并不比简单工厂模式好用
 *
 */

public class RuleConfig {
    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtention = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtention);

        if (parserFactory == null){
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

