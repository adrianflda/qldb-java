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

package software.amazon.qldb.example.actions;

import com.amazon.ion.Decimal;
import com.amazon.ion.IonStruct;
import com.amazon.ion.IonValue;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import software.amazon.qldb.Result;
import software.amazon.qldb.TransactionExecutor;
import software.amazon.qldb.example.Constants;
import software.amazon.qldb.example.helpers.IonHelper;
import software.amazon.qldb.example.helpers.TransactionsHandler;
import software.amazon.qldb.example.models.TransactionLog;
import software.amazon.qldb.example.models.TransactionLogType;
import software.amazon.qldb.example.models.TransactionLogRequest;
import software.amazon.qldb.example.models.TransactionLogResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * The purpose of this class is to encapsulate all the banking actions
 * like checking the balances, * transferring the money etc.
 * </p>
 *
 * <p>
 * We inject the TransactionHandler, which manages the interaction with
 * QLDB driver.
 * </p>
 */
@Slf4j
public class Banking {

    private TransactionsHandler transactionsHandler;

    private IonHelper ionHelper;

    public Banking(@NonNull final TransactionsHandler transactionsHandler,
                   @NonNull final IonHelper ionHelper) {
        this.transactionsHandler = transactionsHandler;
        this.ionHelper = ionHelper;
    }

    public TransactionLogResponse transfer(@NonNull final TransactionLogRequest transactionLogRequest) {

        //Validate that the input parameters are correct
        validateParameters(transactionLogRequest);

        /*
        * transferSuccessful flag should default to false unless we actually
        * mark it to true when Transfer is done successfully
        */
        final TransactionLogResponse response = TransactionLogResponse.builder()
                .transferSuccessful(false)
                .build();

        return transactionsHandler.executeTransaction(txn -> {
                        addEntryInTransactions(txn, transactionLogRequest);
                        response.setTransferSuccessful(true);
                        return response;
                }, (retry) -> log.info("There was an error ")
        );
    }


    private void validateParameters(
            @NonNull final TransactionLogRequest transactionLogRequest) {

        Validate.isTrue(transactionLogRequest.getAmount() > 0);
        Validate.notNull(transactionLogRequest.getTransactionScope());
        Validate.notNull(transactionLogRequest.getTransactionCategory());
        Validate.notNull(transactionLogRequest.getTransactionType());
        Validate.notBlank(transactionLogRequest.getTransactionId());
        Validate.notNull(transactionLogRequest.getTransactionStatus());
        Validate.notNull(transactionLogRequest.getTransactionFees());
        Validate.notNull(transactionLogRequest.getSubjectModel());
        Validate.notBlank(transactionLogRequest.getWalletUUID());
        Validate.notNull(transactionLogRequest.getVersion());
        Validate.notBlank(transactionLogRequest.getDescription());
        Validate.notNull(transactionLogRequest.getGameType());
    }

    /**
     * Create an entry in the Transaction Table. This creates a single document
     * in the transactions table
     *
     * @param txn The TransactionExecutor object which is instantiated during
     *            the QLDB Transaction
     * @param transactionLogRequest
     * @return List of documentIds created in the transactions table
     */
    private List<String> addEntryInTransactions(
            @NonNull final TransactionExecutor txn,
            @NonNull final TransactionLogRequest transactionLogRequest) {

        final TransactionLog transaction = TransactionLog.builder()
            .amount(transactionLogRequest.getAmount())
            .transactionScope(transactionLogRequest.getTransactionScope())
            .transactionCategory(transactionLogRequest.getTransactionCategory())
            .transactionType(transactionLogRequest.getTransactionType())
            .transactionId(transactionLogRequest.getTransactionId())
            .transactionStatus(transactionLogRequest.getTransactionStatus())
            .transactionFees(transactionLogRequest.getTransactionFees())
            .subjectModel(transactionLogRequest.getSubjectModel())
            .walletUUID(transactionLogRequest.getWalletUUID())
            .version(transactionLogRequest.getVersion())
            .description(transactionLogRequest.getDescription())
            .gameType(transactionLogRequest.getGameType())
            .build();

        final String query = "INSERT INTO transaction_log VALUE ? ";
        final IonValue transactionDocument =
                ionHelper.toIonValue(transaction);

        final List<IonValue> parameters =
                Collections.singletonList(transactionDocument);

        final Result result = txn.execute(query, parameters);
        final List<String> insertedDocumentIds = ionHelper.getDocumentIdsFromDmlResult(result);

        log.info("Created entries in Transactions table. " +
                "Inserted document ids {}", insertedDocumentIds);
        return insertedDocumentIds;
    }

}
