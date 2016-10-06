package com.mark.lendingclub.invest.api.service;

import com.mark.lendingclub.invest.api.ApiCallback;
import com.mark.lendingclub.invest.api.AbstractApiClient;
import com.mark.lendingclub.invest.api.model.ApiRequestVO;
import com.mark.lendingclub.invest.api.model.AccountVO;
import com.mark.lendingclub.invest.api.util.ApiUtil;
import com.mark.lendingclub.invest.config.ApplicationState;
import com.mark.lendingclub.invest.config.Configuration;

/**
 * Created by NeVeX on 9/26/2015.
 */
public class ApiAccountService extends AbstractApiClient<AccountVO> {

    private final static String ACCOUNT_RESOURCE = "/accounts/{INVESTOR_ID}/summary";

    public ApiAccountService(ApiCallback<AccountVO> callback) {
        super(callback);

    }

    public void invoke()
    {
        if (Configuration.getConfiguration().isUseMockData())
        {
            onPostExecute(AccountVO.createMock());
        }
        else {
            String url = ACCOUNT_RESOURCE.replace("{INVESTOR_ID}", ApplicationState.getState().getCurrentUser().getLcInvestorId());
            ApiRequestVO<AccountVO> requestVO =
                new ApiRequestVO<>(
                        url,
                        null,
                        ApiUtil.createDotNetApiHeaders(),
                        null,
                        AccountVO.class,
                        0,
                        0);
            execute(requestVO);
        }
    }

    @Override
    protected void onPostExecute(AccountVO accountVO) {
        if ( accountVO != null)
        {
            ApplicationState.getState().setAccountVO(accountVO);
        }
        super.onPostExecute(accountVO);
    }

}
