/*
 * Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: MIT-0
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package software.amazon.qldb.example.tasks;


import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import software.amazon.qldb.example.actions.Banking;
import software.amazon.qldb.example.dagger.components.BankingComponent;
import software.amazon.qldb.example.dagger.components.DaggerBankingComponent;
import software.amazon.qldb.example.models.Balance;
import software.amazon.qldb.example.models.TransactionLogRequest;
import software.amazon.qldb.example.models.TransactionLogResponse;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * This class illustrates the use case of transferring the money between
 * two accounts. We show case two cases in this:
 * </p>
 *
 * <ul>
 *     <li> Only one transfer of money happening at a time </li>
 *     <li> Multiple transfers between same accounts happening in parallel </li>
 * </ul>
 *
 * <p>
 * In the first use case, we will do only one transfer at a time and assume that
 * there is no other
 * conflicting transaction happening in the system.
 *
 * In the second use case, we will spawn multiple threads each doing a
 * transaction of its own but with the same accounts involved.
 * In doing so, some threads will get an OCC error, and they will retry their
 * transaction and eventually succeed. Once all the threads complete,
 * we ensure that the balance across accounts is as expected
 * </p>
 *
 * <p>
 * In these use cases we leverage the ".execute" method of QLDB Java driver.
 * This is a convenience method which takes care of starting the transaction,
 * executing the statements, and  committing the transaction.
 * If, during the commit phase, there is an OCC exception, the method will retry
 * the entire transaction again (till it has exhausted the maximum retry
 * attempts or it times out). With this, the application  does not have to worry
 * about doing the retries manually.
 * </p>
 */
@Slf4j
public class TransferMoney {

    private Banking banking;


    public TransferMoney(@NonNull final Banking banking) {
        this.banking = banking;
    }

    /**
     * This shows transfer of 5000 USD from Account A001 to Account A003
     * We log the balances of Accounts A001 and A003 before and after the
     * transfer.
     *
     * After the Transfer:
     * 1) The USD balance in account A001 should be $5000 less than what we
     * logged initially
     *
     * 2) The USD balance in account A003 should be $5000 more than what we
     * logged initially
     */
    public TransactionLogResponse runSingleTransfer(TransactionLogRequest transactionLogRequest) {
        final TransactionLogResponse transferResponse = banking.transfer(transactionLogRequest);
        return transferResponse
    }

    public static void main(String... args) {
        final BankingComponent bankingComponent = DaggerBankingComponent.builder().build();
        final TransferMoney transferMoney = bankingComponent.providesTransferMoney();
        final TransactionLogRequest transactionLogRequest = TransactionLogRequest.build()
            .amount(args[1])
            .transactionScope(args[2])
            .transactionCategory(args[3])
            .transactionType(args[4])
            .transactionId(args[5])
            .transactionStatus(args[6])
            .transactionFees(args[7])
            .subjectModel(args[8])
            .walletUUID(args[9])
            .version(args[10])
            .description(args[11])
            .gameType(args[12])
            .build()
        if (args.length == 0 || args[0].equals("singleTransfer")) {
            transferMoney.runSingleTransfer(transactionLogRequest);
        } else {
            log.error("Unknown arguments {}",(Object[]) args);
        }
    }
}
