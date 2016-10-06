package com.mark.lendingclub.invest.api.util;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NeVeX on 9/24/2015.
 */
public class JSONUtil {

    public final static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * Try and return a string value for the given field. Returns null otherwise
     */
    public static String tryGetString(JSONObject jsonObject, String fieldName)
    {
        try {
            return jsonObject.getString(fieldName);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * Try and return a double value for the given field. Returns 0 otherwise
     */
    public static double tryGetDouble(JSONObject jsonObject, String fieldName)
    {
        try {
            return jsonObject.getDouble(fieldName);
        }
        catch (Exception e)
        {
            return 0d;
        }
    }

    /**
     * Try and return a integer value for the given field. Returns 0 otherwise
     */
    public static int tryGetInteger(JSONObject jsonObject, String fieldName)
    {
        try {
            return jsonObject.getInt(fieldName);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public static Date tryGetDate(JSONObject jsonObject, String listingEndDate) {
        //2015-09-21T09:01:21.523
        try {
            String dateString = jsonObject.getString(listingEndDate);
            if ( dateString == null )
            {
                return null;
            }
            return new SimpleDateFormat(DATE_FORMAT).parse(dateString);
        }
        catch (Exception e)
        {
            return null;
        }

    }
}
