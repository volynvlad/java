import by.bsu.account.entity.Account;
import by.bsu.account.entity.OperationType;
import by.bsu.account.exception.InvalidDataException;
import by.bsu.account.exception.InvalidFileException;
import by.bsu.account.parser.OperationParse;
import by.bsu.account.reader.OperationReader;
import by.bsu.account.valid.OperationValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
        public static void main(String[] args) {
            try {
                Account account = new Account();
                System.out.println(account);

                OperationReader reader = new OperationReader();
                LinkedList<String> list = reader.readTxt("data/input.txt");

                for (String temp:list){
                    if(OperationValidator.isOperationValid(temp)){
                        long id = OperationParse.takeOperationID(temp);
                        OperationType type = OperationParse.takeOperationType(temp);
                        ArrayList<LocalTime> time = OperationParse.takeOperationTime(temp);
                        float sum = OperationParse.takeOperationSum(temp);
                        account.addOperation(id, type, time, sum);
                    }
                }
                System.out.println();
                System.out.println(account);
                for (Account.OperationInfo o : account.getOperationInfo()) {
                    System.out.println(o.toString());
                }



            } catch (DateTimeException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            } catch (InvalidFileException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            } catch (InvalidDataException e){
                LOGGER.log(Level.ERROR, e.getMessage());
            }


    }
}
