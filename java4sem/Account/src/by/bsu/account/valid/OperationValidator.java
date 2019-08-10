package by.bsu.account.valid;

import by.bsu.account.entity.OperationType;
import by.bsu.account.parser.OperationParse;
import by.bsu.account.util.OperationTag;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationValidator {
    public static boolean isOperationValid(String oper) {
        String string = oper.toUpperCase();
        return isTagContains(string, OperationTag.ID)
                && isTagContains(string, OperationTag.SUM)
                && isTagContains(string, OperationTag.TIME)
                && isTagContains(string, OperationTag.TYPE);
    }

    public static boolean isOperationTypeValid(String typeStr) {
        OperationType[] types = OperationType.values();
        for(OperationType type : types) {
            if (type.toString().equalsIgnoreCase(typeStr)){
                return true;
            }
        }
        return false;
    }

    public static boolean isTagContains(String s, String tag) {
        String regex = "^" + tag + "|" + OperationParse.DELIMETR_REGEX + tag;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        return m.find();
    }
}
