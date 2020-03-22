package factory01.abstractFactory.ConfigV2;

public class PropertiesConfigParserFactory implements IConfigParserFactory {


    @Override
    public IRuleConfigParser createRuleConfigParser() {
        return null;
    }

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return null;
    }
}
