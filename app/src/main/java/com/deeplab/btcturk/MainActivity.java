package com.deeplab.btcturk;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.deeplab.btcturkandroidapi.AllOrders;
import com.deeplab.btcturkandroidapi.Balance;
import com.deeplab.btcturkandroidapi.BtcTurk;
import com.deeplab.btcturkandroidapi.OpenOrders;
import com.deeplab.btcturkandroidapi.Ticker;
import com.deeplab.btcturkandroidapi.Trades;
import com.deeplab.btcturkandroidapi.Transactions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Ticker> tickers = BtcTurk.Ticker();
        for (Ticker in : tickers){
            System.out.println("FB " + in.getPair());
        }

        ArrayList<Ticker> tickersSymbol = BtcTurk.Ticker("BTC_TRY");
        for (Ticker in : tickersSymbol){
            System.out.println("FB " + in.getAsk());
        }

        ArrayList<Trades> trades = BtcTurk.Trades("BTC_TRY",50);
        for(Trades in : trades){
            System.out.println("FB " + in.getPair() + " " + in.getPrice());
        }

        ArrayList<Transactions> userTransactions = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).UserTransactions();
        for (Transactions in : userTransactions){
            System.out.println(in.getId());
        }

        ArrayList<Transactions> userTypeTransactions = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).UserTypeTransactions("buy"); // buy-sell
        for (Transactions in : userTypeTransactions){
            System.out.println(in.getId());
        }

        ArrayList<Transactions> userTypeAndSymbolTransactions = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).UserTypeAndSymbolTransactions("buy","usdt"); // buy-sell , usdt-btc-try...
        for (Transactions in : userTypeAndSymbolTransactions){
            System.out.println(in.getId());
        }

        ArrayList<Transactions> userSymbolTransactions = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).UserSymbolTransactions("usdt"); // usdt-btc-try...
        for (Transactions in : userSymbolTransactions){
            System.out.println(in.getId());
        }

        ArrayList<OpenOrders> openOrdersAsks = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).OpenOrders("BTC_TRY").get(0);
        for (OpenOrders in : openOrdersAsks){
            System.out.println(in.getId());
        }

        ArrayList<OpenOrders> openOrdersBids = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).OpenOrders("BTC_TRY").get(1);
        for (OpenOrders in : openOrdersBids){
            System.out.println(in.getId());
        }

        ArrayList<AllOrders> allOrders = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).AllOrders("BTC_TRY");
        for (AllOrders in : allOrders){
            System.out.println(in.getId());
        }

        ArrayList<Balance> balances = BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).getBalance();
        for (Balance in : balances){
            System.out.println(in.getAsset() + " " + in.getBalance());
        }

        System.out.println(BtcTurk.SetConstants(Constants.API_PUBLIC_KEY,Constants.API_PRIVATE_KEY).SumbitOrder(0.1,200,0,"limit","buy","LINK_TRY"));            }
}