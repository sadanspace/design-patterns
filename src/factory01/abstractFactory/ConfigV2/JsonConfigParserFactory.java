package factory01.abstractFactory.ConfigV2;


public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleConfigParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return new JsonSystemConfigParser();
    }
}
