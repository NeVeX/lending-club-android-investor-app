package com.mark.lendingclub.invest.api.model;

import com.mark.lendingclub.invest.api.ApiResponse;
import com.mark.lendingclub.invest.api.util.JSONUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by NeVeX on 9/24/2015.
 */
public class AccountVO implements ApiResponse<AccountVO>, Serializable {

    private double cashBalance;
    private double accuredInterest;
    private double outstandingPrincipal;
    private double accountTotal;
    private double totalNotes;
    private double totalPortfolios;
    private double inFundingBalance;
    private double recievedInterest;
    private double recievedPrincipal;
    private double recievedLateFees;

    @Override
    public AccountVO convertJSONObject(JSONObject jsonObject) throws JSONException {
        AccountVO apiResponse = new AccountVO();
        apiResponse.setCashBalance(JSONUtil.tryGetDouble(jsonObject, "AvailableCash"));
        apiResponse.setAccountTotal(JSONUtil.tryGetDouble(jsonObject, "AccruedInterest"));
        apiResponse.setOutstandingPrincipal(JSONUtil.tryGetDouble(jsonObject, "OutstandingPrincipal"));
        apiResponse.setAccountTotal(JSONUtil.tryGetDouble(jsonObject, "AccountTotal"));
        apiResponse.setTotalNotes(JSONUtil.tryGetInteger(jsonObject, "TotalNotes"));
        apiResponse.setTotalPortfolios(JSONUtil.tryGetInteger(jsonObject, "TotalPortfolios"));
        apiResponse.setInFundingBalance(JSONUtil.tryGetDouble(jsonObject, "InFundingBalance"));
        apiResponse.setRecievedInterest(JSONUtil.tryGetDouble(jsonObject, "ReceivedInterest"));
        apiResponse.setRecievedPrincipal(JSONUtil.tryGetDouble(jsonObject, "ReceivedPrincipal"));
        apiResponse.setRecievedLateFees(JSONUtil.tryGetDouble(jsonObject, "ReceivedLateFees"));
        return apiResponse;
    }

    @Override
    public AccountVO convertJSONArray(JSONArray jsonArray) throws JSONException {
        throw new UnsupportedOperationException("JSONArray conversion not supported");
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public double getAccuredInterest() {
        return accuredInterest;
    }

    public void setAccuredInterest(double accuredInterest) {
        this.accuredInterest = accuredInterest;
    }

    public double getOutstandingPrincipal() {
        return outstandingPrincipal;
    }

    public void setOutstandingPrincipal(double outstandingPrincipal) {
        this.outstandingPrincipal = outstandingPrincipal;
    }

    public double getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(double accountTotal) {
        this.accountTotal = accountTotal;
    }

    public double getTotalNotes() {
        return totalNotes;
    }

    public void setTotalNotes(double totalNotes) {
        this.totalNotes = totalNotes;
    }

    public double getTotalPortfolios() {
        return totalPortfolios;
    }

    public void setTotalPortfolios(double totalPortfolios) {
        this.totalPortfolios = totalPortfolios;
    }

    public double getInFundingBalance() {
        return inFundingBalance;
    }

    public void setInFundingBalance(double inFundingBalance) {
        this.inFundingBalance = inFundingBalance;
    }

    public double getRecievedInterest() {
        return recievedInterest;
    }

    public void setRecievedInterest(double recievedInterest) {
        this.recievedInterest = recievedInterest;
    }

    public double getRecievedPrincipal() {
        return recievedPrincipal;
    }

    public void setRecievedPrincipal(double recievedPrincipal) {
        this.recievedPrincipal = recievedPrincipal;
    }

    public double getRecievedLateFees() {
        return recievedLateFees;
    }

    public void setRecievedLateFees(double recievedLateFees) {
        this.recievedLateFees = recievedLateFees;
    }

    public static AccountVO createMock()
    {
        Random r = new Random();
        AccountVO accountVO = new AccountVO();
        accountVO.setCashBalance(r.nextDouble() * r.nextInt(60000));
        accountVO.setRecievedLateFees(r.nextDouble() * r.nextInt(60000));
        accountVO.setRecievedPrincipal(r.nextDouble() * r.nextInt(60000));
        accountVO.setRecievedInterest(r.nextDouble() * r.nextInt(60000));
        accountVO.setInFundingBalance(r.nextDouble() * r.nextInt(60000));
        accountVO.setAccountTotal(r.nextDouble() * r.nextInt(60000));
        accountVO.setAccuredInterest(r.nextDouble() * r.nextInt(60000));
        accountVO.setOutstandingPrincipal(r.nextDouble() * r.nextInt(60000));
        accountVO.setTotalNotes(r.nextInt(100));
        accountVO.setTotalPortfolios(r.nextInt(100));
        return accountVO;
    }

}
