package com.spaghettiteam.hotelapi.dto;

import java.time.LocalDate;

public class SearchDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private double lowestPrice;
    private double highestPrice;

    public SearchDTO() {
    }

    public SearchDTO(LocalDate startDate, LocalDate endDate, double lowestPrice, double highestPrice) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public static final class SearchDTOBuilder {
        private LocalDate startDate;
        private LocalDate endDate;
        private double lowestPrice;
        private double highestPrice;

        private SearchDTOBuilder() {
        }

        public static SearchDTOBuilder aSearchDTO() {
            return new SearchDTOBuilder();
        }

        public SearchDTOBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public SearchDTOBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public SearchDTOBuilder withLowestPrice(double lowestPrice) {
            this.lowestPrice = lowestPrice;
            return this;
        }

        public SearchDTOBuilder withHighestPrice(double highestPrice) {
            this.highestPrice = highestPrice;
            return this;
        }

        public SearchDTO build() {
            SearchDTO searchDTO = new SearchDTO();
            searchDTO.setStartDate(startDate);
            searchDTO.setEndDate(endDate);
            searchDTO.setLowestPrice(lowestPrice);
            searchDTO.setHighestPrice(highestPrice);
            return searchDTO;
        }
    }
}
