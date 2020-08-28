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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionLog {

    @JsonProperty("Amount")
    private double amount;

    @JsonProperty("TransactionScope")
    private int transactionScope;

    @JsonProperty("TransactionCategory")
    private int transactionCategory;

    @JsonProperty("TransactionType")
    private int transactionType;

    @JsonProperty("TransactionId")
    private String transactionId;

    @JsonProperty("TransactionStatus")
    private int transactionStatus;

    @JsonProperty("TransactionFees")
    private double transactionFees;

    @JsonProperty("SubjectModel")
    private int subjectModel;

    @JsonProperty("WalletUUID")
    private String walletUUID;

    @JsonProperty("CreatedAt")
    private String createdAt;

    @JsonProperty("UpdatedAt")
    private String updatedAt;

    @JsonProperty("Version")
    private int version;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("GameType")
    private int gameType;
    
}
