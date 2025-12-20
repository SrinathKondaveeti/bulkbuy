package com.bulkbuy.response;

import java.time.LocalDateTime;

public class BulkBuyResponseEntity<T>  {

    private String statusCode;
    private String statusMessage;
    private T data;
    private LocalDateTime timestamp;

    public BulkBuyResponseEntity(String statusCode, String statusMessage, T data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

}
