package com.mark.lendingclub.invest.config;

import com.mark.lendingclub.invest.api.model.AccountVO;
import com.mark.lendingclub.invest.api.model.SearchListingVO;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by NeVeX on 10/11/2015.
 */
public class ApplicationState {

    static
    {
        instance = new ApplicationState();
    }

    private static ApplicationState instance;
    private AccountVO accountVO;
    private UserInformation currentUser;
    private AtomicInteger notificationCounter = new AtomicInteger(0);
    private SearchListingVO searchListingVO;

    private ApplicationState(){}

    public static ApplicationState getState()
    {
        return instance;
    }

    public synchronized AccountVO getAccountVO() {
        return accountVO;
    }

    public synchronized void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }

    public synchronized UserInformation getCurrentUser() {
        return currentUser;
    }

    public synchronized void setCurrentUser(UserInformation currentUser) {
        this.currentUser = currentUser;
    }

    public void removeUserInformation() {
        currentUser = null;
        accountVO = null;
        searchListingVO = null;
    }

    public int getNextUniqueNotificationNumber()
    {
        return notificationCounter.incrementAndGet();
    }

    public void setSearchListingVO(SearchListingVO responseVO) {
        searchListingVO = responseVO;
    }

    public SearchListingVO getSearchListingVO() {
        return searchListingVO;
    }
}
