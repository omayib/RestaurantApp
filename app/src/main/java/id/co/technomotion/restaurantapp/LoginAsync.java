package id.co.technomotion.restaurantapp;

import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

/**
 * Created by omayib on 5/28/15.
 */
public class LoginAsync extends AsyncTask<String,Integer,String> {
    String url="http://private-4f677-restaurantfinder.apiary-mock.com/user/signin";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String responseData="";
        ArrayList<NameValuePair> listValue=new ArrayList<>();
        listValue.add(new BasicNameValuePair("email",params[0]));
        listValue.add(new BasicNameValuePair("password",params[1]));
        try {
             responseData=ClientToServer.eksekusiHttpPost(url,listValue);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return responseData;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
