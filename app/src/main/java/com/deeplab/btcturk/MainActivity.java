package com.deeplab.btcturk;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.deeplab.btcturkandroidapi.Balance;
import com.deeplab.btcturkandroidapi.BtcTurk;
import com.deeplab.btcturkandroidapi.OpenOrders;
import com.deeplab.btcturkandroidapi.Ticker;
import com.deeplab.btcturkandroidapi.Trades;
import com.deeplab.btcturkandroidapi.Transactions;

import java.util.ArrayList;


/*import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.commons.codec.DecoderException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.iharder.Base64;
import javax.xml.bind.DatatypeConverter;*/

public class MainActivity extends AppCompatActivity {

    private static String BASE_URL = "https://api.btcturk.com";
    private static String TICKER = "/api/v2/ticker";
    private static String TRADES = "/api/v2/trades?pairSymbol=";
    private static String BALANCE = "/api/v1/users/balances";
    private static String ORDER = "/api/v1/order";
    private static String TRANSACTIONS = "/api/v1/users/transactions/trade";
    private static String TRANSACTIONS_ALL = "/api/v1/users/transactions/trade?type=buy&type=sell&symbol=btc&symbol=try&symbol=usdt";
    private static String OPEN_ORDER = "/api/v1/openOrders?pairSymbol=";
    private static String ALL_ORDERS = "/api/v1/allOrders?pairSymbol=";
    private TextView mBalance;
    private Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBalance = findViewById(R.id.mBalance);
        mSend = findViewById(R.id.mSend);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ArrayList<Ticker> tickers = BtcTurk.Ticker("BTC_USDT");
                for (Ticker in : tickers){
                    System.out.println("FB " + in.getAsk());
                }*/

                /*ArrayList<Trades> trades = BtcTurk.Trades("BTC_TRY",50);
                for(Trades in : trades){
                    System.out.println("FB " + in.getPair() + " " + in.getPrice());
                }*/

                /*ArrayList<Transactions> transactions = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).UserTransactions();
                for (Transactions in : transactions){
                    System.out.println("FB " + in.getId());
                }*/

                /*ArrayList<OpenOrders> openOrders = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).OpenOrders("BTC_TRY").get(0);
                for (OpenOrders in : openOrders){
                    System.out.println("FB " + in.getId());
                }*/

                /*ArrayList<Balance> balances = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).getBalance();
                for (Balance in : balances){
                    System.out.println("FB " + in.getAsset() + " " + in.getBalance());
                }*/

                BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).SumbitOrder(0.1,200,0,"limit","buy","LINK_TRY");

            }
        });
    }
}