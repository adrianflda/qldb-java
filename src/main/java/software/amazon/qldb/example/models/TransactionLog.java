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

package software.amazon.qldb.example.models;

import com.amazon.ion.Decimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionLog {

    @JsonProperty("Amount")
    private Decimal amount;

    @JsonProperty("TransactionScope")
    private Int transactionScope;

    @JsonProperty("TransactionCategory")
    private Int transactionCategory;

    @JsonProperty("TransactionType")
    private Int transactionType;

    @JsonProperty("TransactionId")
    private String transactionId;

    @JsonProperty("TransactionStatus")
    private Int transactionStatus;

    @JsonProperty("TransactionFees")
    private Decimal transactionFees;

    @JsonProperty("SubjectModel")
    private Int subjectModel;

    @JsonProperty("WalletUUID")
    private String walletUUID;

    @JsonProperty("CreatedAt")
    private Date createdAt;

    @JsonProperty("UpdatedAt")
    private Date updatedAt;

    @JsonProperty("Version")
    private Int version;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("GameType")
    private Int gameType;
    
}