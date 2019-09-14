package lesson20.task2;


import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        validate(transaction);

        int index = 0;
        for(Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transaction;
            }
            index++;
        }

        throw new InternalServerException("There is no free space to save transaction. Transaction " + transaction.getId() + " can't be saved");
    }

    public Transaction[] transactionList() throws BadRequestException {

        Transaction[] transactionsList = new Transaction[countTransactions(transactions)];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                transactionsList[index] = tr;
                index++;
            }
        }
        return transactionsList;
    }
    public Transaction[] transactionList(String city) throws BadRequestException {
        Transaction[] transactionsList = new Transaction[countDefinedCityTransactions(transactions, city)];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                transactionsList[index] = tr;
                index++;
            }
        }
        return transactionsList;

    }
    public Transaction[] transactionList(int amount) throws BadRequestException {
        Transaction[] transactionsList = new Transaction[countDefinedAmountTransactions(transactions, amount)];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                transactionsList[index] = tr;
                index++;
            }
        }
        return transactionsList;

    }

    private void validate(Transaction transaction) throws Exception {

        //сумма больше лимита тразакции
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction amount is bigger than simple transaction limit " + utils.getLimitSimpleTransactionAmount() + " transaction " + transaction.getId() + " can't be saved.");

        //достигнут лимит суммы тразацкий за день
        //достигнут лимит количества тразакций за день
        checkTransactionsPerDayRules(transaction);

        //указан не верный город для транзакции
        checkTransactionCity(transaction);

        //такая транзакция уже есть в хранилище
        for (Transaction tr : transactions) {
            if (transaction.equals(tr))
                throw new BadRequestException("Same transaction is already into storage. Transaction " + transaction.getId() + " can't be saved");
        }
    }

    private void checkTransactionCity(Transaction transaction) throws BadRequestException {
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity()))
                return;
        }

        throw new BadRequestException("Transaction to city: " + transaction.getCity() + " isn't supported. Transaction " + transaction.getId() + " can't be saved");
    }

    private void checkTransactionsPerDayRules(Transaction transaction) throws LimitExceeded {
        int sum = transaction.getAmount();
        int count = 1;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit amount exceed " + transaction.getId() + ". Can't be saved");
        }

        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit count exceed " + transaction.getId() + ". Can't be saved");
        }
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    private int countTransactions(Transaction[] transactions) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                count++;
        }
        return count;
    }

    private int countDefinedCityTransactions(Transaction[] transactions, String city) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city))
                count++;
        }
        return count;
    }


    private int countDefinedAmountTransactions(Transaction[] transactions, int amount) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount)
                count++;
        }
        return count;
    }
}
