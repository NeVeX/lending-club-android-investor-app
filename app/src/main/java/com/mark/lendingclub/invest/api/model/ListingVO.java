package com.mark.lendingclub.invest.api.model;

import com.mark.lendingclub.invest.api.ApiResponse;
import com.mark.lendingclub.invest.api.util.JSONUtil;
import com.mark.lendingclub.invest.util.DebugUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * Created by NeVeX on 9/24/2015.
 */
public class ListingVO implements ApiResponse<ListingVO>, Serializable {

    private int listingNumber;
    private String listingTitle;
    private double estimatedReturn;
    private String prosperRating;
    private double percentFunded;
    private double listingAmount;
    private int loanTermInYears;
    private double amountRemaining;
    private double effectiveYield;
    private double estimatedLoss;
    private Date startDate;
    private int verificationStage;
    private double borrowerRate;
    private String borrowerOccupation;
    private double borrowerDebtToIncomeRatio;
    private int borrowerInquiriesInLastSixMonths;
    private String borrowerFicoScore;
    private double borrowerMonthlyPayment;

    @Override
    public ListingVO convertJSONObject(JSONObject jsonObject) throws JSONException {

        ListingVO listingVO = new ListingVO();
        listingVO.setListingNumber(JSONUtil.tryGetInteger(jsonObject, "id"));
        listingVO.setListingTitle(JSONUtil.tryGetString(jsonObject, "purpose"));
        listingVO.setProsperRating(JSONUtil.tryGetString(jsonObject, "grade"));
        listingVO.setListingAmount(JSONUtil.tryGetDouble(jsonObject, "loanAmount"));
        double fundedAmount = JSONUtil.tryGetDouble(jsonObject, "fundedAmount");
        listingVO.setAmountRemaining(listingVO.listingAmount - fundedAmount);
        listingVO.setEffectiveYield(JSONUtil.tryGetDouble(jsonObject, "EffectiveYield"));
        listingVO.setEstimatedLoss(JSONUtil.tryGetDouble(jsonObject, "EstimatedLossRate"));
        listingVO.setStartDate(JSONUtil.tryGetDate(jsonObject, "listD"));
        listingVO.setVerificationStage(JSONUtil.tryGetInteger(jsonObject, "reviewStatus"));
//        listingVO.setBorrowerRate(JSONUtil.tryGetDouble(jsonObject, "intRate"));
        listingVO.setBorrowerOccupation(JSONUtil.tryGetString(jsonObject, "empTitle"));
        listingVO.setBorrowerDebtToIncomeRatio(JSONUtil.tryGetDouble(jsonObject, "dti"));
        listingVO.setBorrowerInquiriesInLastSixMonths(JSONUtil.tryGetInteger(jsonObject, "inqLast6Mths"));
        listingVO.setBorrowerFicoScore(JSONUtil.tryGetString(jsonObject, "ficoRangeLow"));
        listingVO.setBorrowerMonthlyPayment(JSONUtil.tryGetDouble(jsonObject, "installment"));

        // the loan term is in months
        int loanTerm = JSONUtil.tryGetInteger(jsonObject, "term");
        if ( loanTerm > 0)
        {
            loanTerm /= 12;
        }
        listingVO.setLoanTermInYears(loanTerm);
        if ( listingVO.listingAmount > 0) {
            listingVO.setPercentFunded( (listingVO.amountRemaining / listingVO.listingAmount) * 100 );
        }
        listingVO.setEstimatedReturn(JSONUtil.tryGetDouble(jsonObject, "intRate"));

        return listingVO;
    }

    @Override
    public ListingVO convertJSONArray(JSONArray jsonArray) throws JSONException {
        throw new UnsupportedOperationException("JSONArray conversion not supported");
    }

    public int getListingNumber() {
        return listingNumber;
    }

    public void setListingNumber(int listingNumber) {
        this.listingNumber = listingNumber;
    }

    public String getListingTitle() {
        return listingTitle;
    }

    public void setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
    }

    public double getEstimatedReturn() {
        return estimatedReturn;
    }

    public void setEstimatedReturn(double estimatedReturn) {
        this.estimatedReturn = estimatedReturn;
    }

    public String getProsperRating() {
        return prosperRating;
    }

    public void setProsperRating(String prosperRating) {
        this.prosperRating = prosperRating;
    }

    public double getPercentFunded() {
        return percentFunded;
    }

    public void setPercentFunded(double percentFunded) {
        this.percentFunded = percentFunded;
    }

    public double getListingAmount() {
        return listingAmount;
    }

    public void setListingAmount(double listingAmount) {
        this.listingAmount = listingAmount;
    }

    public int getLoanTermInYears() {
        return loanTermInYears;
    }

    public void setLoanTermInYears(int loanTermInYears) {
        this.loanTermInYears = loanTermInYears;
    }

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(double amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public double getEffectiveYield() {
        return effectiveYield;
    }

    public void setEffectiveYield(double effectiveYield) {
        this.effectiveYield = effectiveYield;
    }

    public double getEstimatedLoss() {
        return estimatedLoss;
    }

    public void setEstimatedLoss(double estimatedLoss) {
        this.estimatedLoss = estimatedLoss;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getVerificationStage() {
        return verificationStage;
    }

    public void setVerificationStage(int verificationStage) {
        this.verificationStage = verificationStage;
    }

    public double getBorrowerRate() {
        return borrowerRate;
    }

    public void setBorrowerRate(double borrowerRate) {
        this.borrowerRate = borrowerRate;
    }

    public String getBorrowerOccupation() {
        return borrowerOccupation;
    }

    public void setBorrowerOccupation(String borrowerOccupation) {
        this.borrowerOccupation = borrowerOccupation;
    }

    public double getBorrowerDebtToIncomeRatio() {
        return borrowerDebtToIncomeRatio;
    }

    public void setBorrowerDebtToIncomeRatio(double borrowerDebtToIncomeRatio) {
        this.borrowerDebtToIncomeRatio = borrowerDebtToIncomeRatio;
    }

    public int getBorrowerInquiriesInLastSixMonths() {
        return borrowerInquiriesInLastSixMonths;
    }

    public void setBorrowerInquiriesInLastSixMonths(int borrowerInquiriesInLastSixMonths) {
        this.borrowerInquiriesInLastSixMonths = borrowerInquiriesInLastSixMonths;
    }

    public String getBorrowerFicoScore() {
        return borrowerFicoScore;
    }

    public void setBorrowerFicoScore(String borrowerFicoScore) {
        this.borrowerFicoScore = borrowerFicoScore;
    }

    public double getBorrowerMonthlyPayment() {
        return borrowerMonthlyPayment;
    }

    public void setBorrowerMonthlyPayment(double borrowerMonthlyPayment) {
        this.borrowerMonthlyPayment = borrowerMonthlyPayment;
    }

    public static ListingVO createMock()
    {
        Random r = new Random();
        ListingVO listingVO = new ListingVO();
        listingVO.setAmountRemaining(r.nextDouble() * 25000);
        listingVO.setBorrowerDebtToIncomeRatio(r.nextDouble());
        listingVO.setBorrowerFicoScore("" + (r.nextInt(250) + 600));
        listingVO.setBorrowerInquiriesInLastSixMonths(r.nextInt(10));
        listingVO.setBorrowerOccupation("TEST OCCUPATION");
        listingVO.setListingTitle("Test Listing Title");
        listingVO.setBorrowerRate(r.nextDouble());
        listingVO.setEffectiveYield(r.nextDouble());
        listingVO.setEstimatedLoss(r.nextDouble());
        listingVO.setEstimatedReturn(r.nextDouble());
        listingVO.setListingAmount(r.nextInt(34000) + 1000);
        listingVO.setListingNumber(r.nextInt(5000) + 1);
        listingVO.setLoanTermInYears(r.nextInt(5) + 1);
        listingVO.setPercentFunded(r.nextDouble());
        listingVO.setProsperRating(DebugUtil.getRandomProsperRating());
        listingVO.setStartDate(new Date());
        listingVO.setVerificationStage(2);
        listingVO.setBorrowerMonthlyPayment(r.nextInt(500)+100);
        return listingVO;
    }

}
