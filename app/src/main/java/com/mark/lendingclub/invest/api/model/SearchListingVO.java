package com.mark.lendingclub.invest.api.model;

import com.mark.lendingclub.invest.api.ApiResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeVeX on 9/24/2015.
 */
public class SearchListingVO implements ApiResponse<SearchListingVO> {

    private List<ListingVO> listings;
    private boolean endOfSearch;

    @Override
    public SearchListingVO convertJSONObject(JSONObject jsonObject) throws JSONException {
        SearchListingVO searchListingVO = new SearchListingVO();
        endOfSearch = true;
        if ( jsonObject != null )
        {
            searchListingVO.setListings(new ArrayList<ListingVO>());
            ListingVO listingConvertVO = new ListingVO();
            JSONArray array = jsonObject.getJSONArray("loans");
            if ( array != null ) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jo = array.getJSONObject(i);
                    searchListingVO.getListings().add(listingConvertVO.convertJSONObject(jo));
                }
                endOfSearch = searchListingVO.getListings().size() == 0;
            }
        }
        return searchListingVO;
    }

    @Override
    public SearchListingVO convertJSONArray(JSONArray jsonArray) throws JSONException {
        return null;
    }

    public List<ListingVO> getListings() {
        return listings;
    }

    public void setListings(List<ListingVO> listings) {
        this.listings = listings;
    }

    public boolean isEndOfSearch() {
        return endOfSearch;
    }

    public void setEndOfSearch(boolean endOfSearch) {
        this.endOfSearch = endOfSearch;
    }

}
