package by.bsu.account.parser;

import by.bsu.account.entity.OperationType;
import by.bsu.account.exception.InvalidDataException;
import by.bsu.account.util.OperationTag;
import by.bsu.account.valid.OperationValidator;

import java.net.Proxy;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OperationParse {
    public static final String DELIMETR_REGEX = "[\\|; ]";
    public static final String DELIMETR_NAME = "[\\|;]";

    public static long takeOperationID(String str) throws InvalidDataException {
        long l;
        try {
            if (OperationValidator.isOperationValid(str)) {
                int index = str.toUpperCase().indexOf(OperationTag.ID) + OperationTag.ID.length();
                Scanner scanner = new Scanner(str.substring(index));
                scanner.useDelimiter(DELIMETR_REGEX);
                l = scanner.nextLong();
            } else {
                throw new InvalidDataException("Not valid operation! Error in ID");
            }
        } catch (InputMismatchException e) {
            throw new InvalidDataException("ID format wrong");
        }
        return l;
    }

    public static float takeOperationSum(String str) throws InvalidDataException {
        float f;
        try {
            if (OperationValidator.isOperationValid(str)) {
                int index = str.toUpperCase().indexOf(OperationTag.SUM) + OperationTag.SUM.length();
                Scanner scanner = new Scanner(str.substring(index));
                scanner.useDelimiter(DELIMETR_REGEX);
                f = scanner.nextFloat();
            } else {
                throw new InvalidDataException("Not valid operation! Error in sum");
            }
        } catch (InputMismatchException e) {
            throw new InvalidDataException("Sum format wrong");
        }
        return f;
    }

    public static ArrayList<LocalTime> takeOperationTime(String str) throws InvalidDataException {
        ArrayList<LocalTime> listTime = new ArrayList<>();
        try {
            if (OperationValidator.isOperationValid(str)) {
                int index = str.toUpperCase().indexOf(OperationTag.TIME) + OperationTag.TIME.length();
                Scanner scanner = new Scanner(str.substring(index));
                scanner.useDelimiter(DELIMETR_REGEX);
                while(scanner.hasNextInt()){
                    int h = scanner.nextInt();
                    if((scanner.hasNextInt())) {
                        int m = scanner.nextInt();
                        listTime.add(LocalTime.of(h, m));
                    }
                }

            } else {
                throw new InvalidDataException("Not valid operation! Error in time!");
            }
        }catch (InputMismatchException e){
            throw new InvalidDataException("time format ron!");
        }
        return listTime;
    }

    public static OperationType takeOperationType(String str) throws InvalidDataException {
        OperationType type;

        if(OperationValidator.isOperationValid(str)) {
            int index = str.toUpperCase().indexOf(OperationTag.TYPE) + OperationTag.TYPE.length();
            Scanner scanner = new Scanner(str.substring(index));
            scanner.useDelimiter(DELIMETR_REGEX);
            String typeStr = scanner.next();
            if (OperationValidator.isOperationTypeValid(typeStr)) {
                return OperationType.valueOf(typeStr);
            } else {
                throw new InvalidDataException("Not valid operation! Error in type!)");
            }
        } else {
            throw new InvalidDataException("Not valid operation");
        }
    }

}
