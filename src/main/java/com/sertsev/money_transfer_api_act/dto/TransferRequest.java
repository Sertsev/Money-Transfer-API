package com.sertsev.money_transfer_api_act.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferRequest {
    private Long senderId;
    private Long receiverId;
    private Double amount;
    private String reason;
}
