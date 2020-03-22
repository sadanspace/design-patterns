package factory01.factoryMethod.RuleConfigV1;

public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {

        return new PropertiesRuleConfigParser();
    }
}
