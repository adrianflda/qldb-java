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

package software.amazon.qldb.example.dagger.modules;

import dagger.Module;
import dagger.Provides;
import software.amazon.qldb.example.actions.Banking;
import software.amazon.qldb.example.actions.ledgermanagement.CreateLedger;
import software.amazon.qldb.example.actions.ledgermanagement.DescribeLedger;
import software.amazon.qldb.example.actions.ledgermanagement.ListLedgers;
import software.amazon.qldb.example.actions.tablesmanagement.CreateIndexes;
import software.amazon.qldb.example.actions.tablesmanagement.CreateTables;
import software.amazon.qldb.example.tasks.SetupLedger;
import software.amazon.qldb.example.tasks.SetupTables;
import software.amazon.qldb.example.tasks.TransferMoney;

import javax.inject.Named;

@Module
public class TasksModule {

    @Provides
    @Named("setupLedger")
    public SetupLedger providesSetupLedger(@Named("createLedger") final CreateLedger createLedger,
                                    @Named("describeLedger") final  DescribeLedger describeLedger,
                                    @Named("listLedgers") final ListLedgers listLedgers)  {
        return new SetupLedger(createLedger, describeLedger, listLedgers);
    }

    @Provides
    @Named("setupTables")
    public SetupTables providesSetupTables(@Named("createTables") final CreateTables createTables,
                                           @Named("createIndexes") final CreateIndexes createIndexes) {
        return new SetupTables(createTables, createIndexes);
    }

    @Provides
    @Named("transferMoney")
    public TransferMoney providesTransferMoney(@Named("banking") final Banking banking) {
        return new TransferMoney(banking);
    }
}
