package factory01.abstractFactory.ConfigV2;

public interface IConfigParserFactory {
    IRuleConfigParser createRuleConfigParser();
    ISystemConfigParser createSystemConfigParser();
}
