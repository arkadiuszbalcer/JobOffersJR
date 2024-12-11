package com.junioroffers.domain.offer.dto;

public record JobOfferResponseDto(
        String title,
        String company,
        String salary,
        String offerUrl
) {
}
