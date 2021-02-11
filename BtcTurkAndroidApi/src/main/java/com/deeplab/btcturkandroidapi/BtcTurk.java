package com.deeplab.btcturkandroidapi;

import android.os.StrictMode;

import net.iharder.Base64;

import org.apache.commons.codec.DecoderException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class BtcTurk {
    private static String BASE_URL = "https://api.btcturk.com";
    private static String TICKER = "/api/v2/ticker";
    private static String TRADES = "/api/v2/trades?pairSymbol=";
    private static String BALANCE = "/api/v1/users/balances";
    private static String ORDER = "/api/v1/order";
    private static String TRANSACTIONS = "/api/v1/users/transactions/trade";
    private static String TRANSACTIONS_ALL = "/api/v1/users/transactions/trade?type=buy&type=sell&symbol=btc&symbol=try&symbol=usdt";
    private static String OPEN_ORDER = "/api/v1/openOrders?pairSymbol=";
    private static String ALL_ORDERS = "/api/v1/allOrders?pairSymbol=";
    private static String API_PUBLIC_KEY;
    private static String API_PRIVATE_KEY;

    private static ArrayList<AllOrders> allOrders = new ArrayList<>();
    private static ArrayList<Balance> balances = new ArrayList<>();
    private static ArrayList<ArrayList<OpenOrders>> openOrders = new ArrayList<>();
    private static ArrayList<Ticker> tickers = new ArrayList<>();
    private static ArrayList<Trades> trades = new ArrayList<>();
    private static ArrayList<Transactions> transactions = new ArrayList<>();

    // Public Endpoints
    public static ArrayList<Ticker> Ticker(){
        StringBuilder result = new StringBuilder();
        try{
            tickers.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                URL url = new URL(BASE_URL + TICKER);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB " + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length();i++){
                JSONObject data = jsonArray.getJSONObject(i);
                String pair = data.getString("pair");
                String pairNormalized = data.getString("pairNormalized");
                long timestamp = data.getLong("timestamp");
                double last = data.getDouble("last");
                double high = data.getDouble("high");
                double low = data.getDouble("low");
                double bid = data.getDouble("bid");
                double ask = data.getDouble("ask");
                double open = data.getDouble("open");
                double volume = data.getDouble("volume");
                double average = data.getDouble("average");
                double daily = data.getDouble("daily");
                double dailyPercent = data.getDouble("dailyPercent");
                String denominatorSymbol = data.getString("denominatorSymbol");
                String numeratorSymbol = data.getString("numeratorSymbol");
                tickers.add(new Ticker(pair,pairNormalized,timestamp,last,high,low,bid,ask,open,volume,average,daily,dailyPercent,denominatorSymbol,numeratorSymbol));
            }
            return tickers;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    public static ArrayList<Ticker> Ticker(String pairSymbol){
        StringBuilder result = new StringBuilder();
        try{
            tickers.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                URL url = new URL(BASE_URL + TICKER + "?pairSymbol=" + pairSymbol);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB " + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length();i++){
                JSONObject data = jsonArray.getJSONObject(i);
                String pair = data.getString("pair");
                String pairNormalized = data.getString("pairNormalized");
                long timestamp = data.getLong("timestamp");
                double last = data.getDouble("last");
                double high = data.getDouble("high");
                double low = data.getDouble("low");
                double bid = data.getDouble("bid");
                double ask = data.getDouble("ask");
                double open = data.getDouble("open");
                double volume = data.getDouble("volume");
                double average = data.getDouble("average");
                double daily = data.getDouble("daily");
                double dailyPercent = data.getDouble("dailyPercent");
                String denominatorSymbol = data.getString("denominatorSymbol");
                String numeratorSymbol = data.getString("numeratorSymbol");
                tickers.add(new Ticker(pair,pairNormalized,timestamp,last,high,low,bid,ask,open,volume,average,daily,dailyPercent,denominatorSymbol,numeratorSymbol));
            }
            return tickers;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    public static ArrayList<Trades> Trades(String pairSymbol, int last) {
        StringBuilder result = new StringBuilder();
        try{
            trades.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                URL url = new URL(BASE_URL + TRADES + pairSymbol + "&last=" + last);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String pair = data.getString("pair");
                String pairNormalized = data.getString("pairNormalized");
                String numerator = data.getString("numerator");
                String denominator = data.getString("denominator");
                long date = data.getLong("date");
                String tid = data.getString("tid");
                String price = data.getString("price");
                String amount = data.getString("amount");
                trades.add(new Trades(pair,pairNormalized,numerator,denominator,date,tid,price,amount));
            }
            return trades;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    /*
     *@param publicKey;
     *@param privateKey;
     */

    public static BtcTurk SetConstants(String publicKey, String privateKey){
        BtcTurk btcTurk = new BtcTurk();
        API_PUBLIC_KEY = publicKey;
        API_PRIVATE_KEY = privateKey;
        return btcTurk;
    }

    // Private Endpoints
    public ArrayList<Transactions> UserTransactions(){
        StringBuilder result = new StringBuilder();
        try{
            transactions.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{

                String unixTimeStamp = String.valueOf(System.currentTimeMillis());
                URL url = new URL(BASE_URL + TRANSACTIONS_ALL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
                urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
                urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String numeratorSymbol = data.getString("numeratorSymbol");
                String denominatorSymbol = data.getString("denominatorSymbol");
                String orderType = data.getString("orderType");
                int id = data.getInt("id");
                long timestamp = data.getLong("timestamp");
                double orderFund = data.getDouble("amount");
                double fee = data.getDouble("fee");
                double tax = data.getDouble("tax");
                transactions.add(new Transactions(numeratorSymbol,denominatorSymbol,orderType,id,timestamp,orderFund,fee,tax));
            }
            return transactions;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    // input buy - sell
    public ArrayList<Transactions> UserTypeTransactions(String type){
        StringBuilder result = new StringBuilder();
        try{
            transactions.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{

                String unixTimeStamp = String.valueOf(System.currentTimeMillis());
                URL url = new URL(BASE_URL + TRANSACTIONS + "?type="+type +"&symbol=btc&symbol=try&symbol=usdt");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
                urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
                urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String numeratorSymbol = data.getString("numeratorSymbol");
                String denominatorSymbol = data.getString("denominatorSymbol");
                String orderType = data.getString("orderType");
                int id = data.getInt("id");
                long timestamp = data.getLong("timestamp");
                double orderFund = data.getDouble("amount");
                double fee = data.getDouble("fee");
                double tax = data.getDouble("tax");
                transactions.add(new Transactions(numeratorSymbol,denominatorSymbol,orderType,id,timestamp,orderFund,fee,tax));
            }
            return transactions;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    // input 1 buy - sell input 2 try - btc - usdt
    public ArrayList<Transactions> UserTypeAndSymbolTransactions(String type, String symbol){
        StringBuilder result = new StringBuilder();
        try{
            transactions.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{

                String unixTimeStamp = String.valueOf(System.currentTimeMillis());
                URL url = new URL(BASE_URL + TRANSACTIONS + "?type="+type +"&symbol=" + symbol);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
                urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
                urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String numeratorSymbol = data.getString("numeratorSymbol");
                String denominatorSymbol = data.getString("denominatorSymbol");
                String orderType = data.getString("orderType");
                int id = data.getInt("id");
                long timestamp = data.getLong("timestamp");
                double orderFund = data.getDouble("amount");
                double fee = data.getDouble("fee");
                double tax = data.getDouble("tax");
                transactions.add(new Transactions(numeratorSymbol,denominatorSymbol,orderType,id,timestamp,orderFund,fee,tax));
            }
            return transactions;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    // input try - btc - usdt
    public ArrayList<Transactions> UserSymbolTransactions(String symbol){
        StringBuilder result = new StringBuilder();
        try{
            transactions.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                String unixTimeStamp = String.valueOf(System.currentTimeMillis());
                URL url = new URL(BASE_URL + TRANSACTIONS +"?type=buy&type=sell&symbol=" + symbol);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
                urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
                urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String numeratorSymbol = data.getString("numeratorSymbol");
                String denominatorSymbol = data.getString("denominatorSymbol");
                String orderType = data.getString("orderType");
                int id = data.getInt("id");
                long timestamp = data.getLong("timestamp");
                double orderFund = data.getDouble("amount");
                double fee = data.getDouble("fee");
                double tax = data.getDouble("tax");
                transactions.add(new Transactions(numeratorSymbol,denominatorSymbol,orderType,id,timestamp,orderFund,fee,tax));
            }
            return transactions;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    // input BTC_TRY
    public ArrayList<ArrayList<OpenOrders>> OpenOrders(String symbol){
        StringBuilder result = new StringBuilder();
        ArrayList<OpenOrders> asksArrays = new ArrayList<>();
        ArrayList<OpenOrders> bidsArrays = new ArrayList<>();
        try{
            openOrders.clear();
            asksArrays.clear();
            bidsArrays.clear();

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                String unixTimeStamp = String.valueOf(System.currentTimeMillis());
                URL url = new URL(BASE_URL + OPEN_ORDER + symbol);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
                urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
                urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray asksArray = data.getJSONArray("asks");
            for (int i = 0; i < asksArray.length(); i++) {
                JSONObject asks = asksArray.getJSONObject(i);
                int id = asks.getInt("id");
                String numeratorSymbol = asks.getString("numeratorSymbol");
                String price = asks.getString("price");
                String amount = asks.getString("amount");
                String quantity = asks.getString("quantity");
                String stopPrice = asks.getString("stopPrice");
                String pairSymbol = asks.getString("pairSymbol");
                String pairSymbolNormalized = asks.getString("pairSymbolNormalized");
                String type = asks.getString("type");
                String method = asks.getString("method");
                String orderClientId = asks.getString("orderClientId");
                long time = asks.getLong("time");
                long updateTime = asks.getLong("updateTime");
                String status = asks.getString("status");
                String leftAmount = asks.getString("leftAmount");
                System.out.println("FB " + price);
                asksArrays.add(new OpenOrders(id,numeratorSymbol,price,amount,quantity,stopPrice,pairSymbol,pairSymbolNormalized,type,method,orderClientId,time,updateTime,status,leftAmount));
            }

            JSONArray bidsArray = data.getJSONArray("bids");
            for (int i = 0; i < bidsArray.length(); i++) {
                JSONObject bids = bidsArray.getJSONObject(i);
                int id = bids.getInt("id");
                String numeratorSymbol = bids.getString("numeratorSymbol");
                String price = bids.getString("price");
                String amount = bids.getString("amount");
                String quantity = bids.getString("quantity");
                String stopPrice = bids.getString("stopPrice");
                String pairSymbol = bids.getString("pairSymbol");
                String pairSymbolNormalized = bids.getString("pairSymbolNormalized");
                String type = bids.getString("type");
                String method = bids.getString("method");
                String orderClientId = bids.getString("orderClientId");
                long time = bids.getLong("time");
                long updateTime = bids.getLong("updateTime");
                String status = bids.getString("status");
                String leftAmount = bids.getString("leftAmount");
                bidsArrays.add(new OpenOrders(id,numeratorSymbol,price,amount,quantity,stopPrice,pairSymbol,pairSymbolNormalized,type,method,orderClientId,time,updateTime,status,leftAmount));
            }

            openOrders.add(asksArrays);
            openOrders.add(bidsArrays);

            return openOrders;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    // input BTC_TRY
    public ArrayList<AllOrders> AllOrders(String pairSymbol){
        StringBuilder result = new StringBuilder();
        try{
            allOrders.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                String unixTimeStamp = String.valueOf(System.currentTimeMillis());
                URL url = new URL(BASE_URL + ALL_ORDERS + pairSymbol);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
                urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
                urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                int id = data.getInt("id");
                String price = data.getString("price");
                String amount = data.getString("amount");
                String quantity = data.getString("quantity");
                String pairsymbol = data.getString("pairsymbol");
                String pairsymbolnormalized = data.getString("pairsymbolnormalized");
                String type = data.getString("type");
                String method = data.getString("method");
                String orderClientId = data.getString("orderClientId");
                long time = data.getLong("time");
                long updateTime = data.getLong("updateTime");
                String status = data.getString("status");
                allOrders.add(new AllOrders(id,price,amount,quantity,pairsymbol,pairsymbolnormalized,type,method,orderClientId,time,updateTime,status));
            }
            return allOrders;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }

    public ArrayList<Balance> getBalance() {
        StringBuilder result = new StringBuilder();
        try{
            balances.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                String unixTimeStamp = String.valueOf(System.currentTimeMillis());
                URL url = new URL(BASE_URL + BALANCE);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
                urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
                urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String  inputLine;
                while ((inputLine = reader.readLine())!= null){
                    result.append(inputLine);
                }
            }catch (Exception e){
                System.out.println("FB ERR" + e.toString());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(result.toString()));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String asset = data.getString("asset");
                String assetname = data.getString("assetname");
                String balance = data.getString("balance");
                String locked = data.getString("locked");
                String free = data.getString("free");
                String orderFund = data.getString("orderFund");
                String requestFund = data.getString("requestFund");
                String precision = data.getString("precision");
                balances.add(new Balance(asset,assetname,balance,locked,free,orderFund,requestFund,precision));
            }
            return balances;
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return null;
        }
    }


    public String SumbitOrder(double quantity, double price, double stopPrice, String orderMethod, String orderType, String pairSymbol){
        try{
            transactions.clear();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            JSONObject params = new JSONObject();
            params.put("quantity",new Double(quantity));
            params.put("price",new Double(price));
            params.put("stopPrice", new Double(stopPrice));
            params.put("newOrderClientId","");
            params.put("orderMethod",orderMethod);
            params.put("orderType",orderType);
            params.put("pairSymbol",pairSymbol);

            String unixTimeStamp = String.valueOf(System.currentTimeMillis());
            URL url = new URL(BASE_URL + ORDER);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("X-PCK", API_PUBLIC_KEY);
            urlConnection.setRequestProperty("X-Stamp", unixTimeStamp);
            urlConnection.setRequestProperty("X-Signature", getSignature(unixTimeStamp));
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(params.toString());
            bufferedWriter.flush();
            int statusCode = urlConnection.getResponseCode();
            System.out.println("The status code is " + statusCode);

            if (statusCode == 200)
                return "Success";
            else if (statusCode == 400)
                return "Bad Request -- Your request is invalid.";
            else if (statusCode == 401)
                return "Unauthorized -- Your Public/Private API key is wrong.";
            else if (statusCode == 429)
                return "Too Many Requests -- You exceeded request rate limit.";
            else if (statusCode == 503)
                return "Service Unavailable -- We're temporarily offline for maintenance. Please try again later.";
            else
                return "No problem messages";
        }catch (Exception error){
            System.out.println("FB ERR " + error.getMessage() + " " +error.toString());
            return  error.toString();
        }
    }

    private static String getSignature(String unixTimeStamp) throws IOException, InvalidKeyException, NoSuchAlgorithmException, DecoderException {
        String data = API_PUBLIC_KEY + unixTimeStamp;
        Mac mac = Mac.getInstance("HmacSHA256");
        byte[] secretKey = DatatypeConverter.parseBase64Binary(API_PRIVATE_KEY);
        SecretKeySpec signingKey = new SecretKeySpec(secretKey, "HmacSHA256");
        mac.init(signingKey);
        byte[] bytes = data.getBytes("UTF-8");
        byte[] rawHmac = mac.doFinal(bytes);
        return Base64.encodeBytes(rawHmac);
    }

}