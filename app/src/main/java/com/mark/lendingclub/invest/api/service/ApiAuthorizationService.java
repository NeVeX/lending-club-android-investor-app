package com.mark.lendingclub.invest.api.service;

import com.mark.lendingclub.invest.api.ApiCallback;
import com.mark.lendingclub.invest.api.model.AccountVO;
import com.mark.lendingclub.invest.config.ApiType;
import com.mark.lendingclub.invest.config.Configuration;

/**
 * Created by NeVeX on 9/26/2015.
 */
public class ApiAuthorizationService implements ApiCallback<AccountVO> {

    private ApiCallback<Boolean> callback;

    public ApiAuthorizationService(ApiCallback<Boolean> callback) {
        this.callback = callback;
    }

    public void invoke()
    {
        if ( Configuration.getConfiguration().getApiType() == ApiType.DotNet)
        {
            new ApiAccountService(this).invoke();
        }
        else {
            // TODO: change this to java when it's implemented
            new ApiAccountService(this).invoke();
        }
    }

    @Override
    public void onApiResponse(AccountVO data) {
        callback.onApiResponse(data != null);
    }
}
