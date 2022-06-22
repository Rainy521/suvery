package com.lwch.survey.model;

public class CompanyInstrumentMember {
    private String instrumentId;

    private String companyName;

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", instrumentId=").append(instrumentId);
        sb.append(", companyName=").append(companyName);
        sb.append("]");
        return sb.toString();
    }
}