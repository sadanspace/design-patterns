package factory01.abstractFactory.ConfigV1;

public class JsonRuleConfigParser implements IRuleConfigParser {
    @Override
    public Config parse(String configText) {
        System.out.println("JsonRuleConfigParser");
        return null;
    }
}
