package factory01.abstractFactory.ConfigV2;

public class XmlConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleConfigParser() {
        return null;
    }

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return null;
    }
}
