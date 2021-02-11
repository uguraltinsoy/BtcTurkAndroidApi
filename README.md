# BtcTurk Android Api

## Download
### AndroidManifest
Android:
```
 <uses-permission android:name="android.permission.INTERNET"/>
```
### Build Gradle
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```
dependencies {
	implementation 'com.github.uguraltinsoy:BtcTurkAndroidApi:0.1.1'
}
```
or Maven:
```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
```
<dependency>
	<groupId>com.github.uguraltinsoy</groupId>
	<artifactId>BtcTurkAndroidApi</artifactId>
	<version>0.1.1</version>
</dependency>
```

## Usage
### Public API Methods
#### Ticker
```
ArrayList<Ticker> tickers = BtcTurk.Ticker();
for (Ticker in : tickers){
    System.out.println(in.getPair());
}
```
```
ArrayList<Ticker> tickers = BtcTurk.Ticker("BTC_TRY");
for (Ticker in : tickers){
    System.out.println(in.getPair());
}
```
#### Trades
```
ArrayList<Trades> trades = BtcTurk.Trades("BTC_TRY",50);
for(Trades in : trades){
    System.out.println(in.getPair() + " " + in.getPrice());
}
```
### Private API Methods
#### Transactions
```
ArrayList<Transactions> userTransactions = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).UserTransactions();
for (Transactions in : userTransactions){
    System.out.println(in.getId());
}
```
```
ArrayList<Transactions> userTypeTransactions = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).UserTypeTransactions("buy"); // buy-sell
for (Transactions in : userTypeTransactions){
    System.out.println(in.getId());
}
```
```
ArrayList<Transactions> userTypeAndSymbolTransactions = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).UserTypeAndSymbolTransactions("buy","usdt"); // buy-sell , usdt-btc-try...
for (Transactions in : userTypeAndSymbolTransactions){
    System.out.println(in.getId());
}
```
```
ArrayList<Transactions> transactions = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).UserSymbolTransactions("usdt"); // usdt-btc-try...
for (Transactions in : transactions){
    System.out.println(in.getId());
}
```
#### Open Orders
Asks Result:
```
ArrayList<OpenOrders> openOrdersAsks = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).OpenOrders("BTC_TRY").get(0);
for (OpenOrders in : openOrdersAsks){
    System.out.println(in.getId());
}
```
Bids Result:
```
ArrayList<OpenOrders> openOrdersBids = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).OpenOrders("BTC_TRY").get(1);
for (OpenOrders in : openOrdersBids){
    System.out.println(in.getId());
}
```
#### All Orders
```
ArrayList<AllOrders> allOrders = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).AllOrders("BTC_TRY");
for (AllOrders in : allOrders){
    System.out.println(in.getId());
}
```
#### Account Balance
```
ArrayList<Balance> balances = BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).getBalance();
for (Balance in : balances){
    System.out.println(in.getAsset() + " " + in.getBalance());
}
```
#### Submit Order
- quantity: "decimal", Mandatory for market or limit orders.
price: "decimal", Price field will be ignored for market orders. Market orders get filled with different prices until your order is completely filled. There is a 5% limit on the difference between the first price and the last price. İ.e. you can't buy at a price more than 5% higher than the best sell at the time of order submission and you can't sell at a price less than 5% lower than the best buy at the time of order submission.
- stopPrice: "decimal", For stop orders
- orderMethod: "enum", "limit", "market" or "stoplimit"
- orderType: "enum", "buy", "sell"
- pairSymbol: "string", ex: "BTCTRY", "ETHTRY"

return String message
```
System.out.println(BtcTurk.SetConstants(API_PUBLIC_KEY,API_PRIVATE_KEY).SumbitOrder(0.1,200,0,"limit","buy","LINK_TRY"));
```

### Developer By
##### Uğur Altınsoy

### Donate
```
BTC  : 1N7V3wX4xvGfwgBP1zQrcMSxohKKfiDxyH
ETH  : 0x0df6da87e219fb4854e933f1071ad91d17afa517
XRP  : rEb8TK3gBgk5auZkwc6sHnwrGVJH8DuaLh
DOGE : DKKmSHAa8GhAE5HNjmCXzkXPKTjpybY3mq
```

### Social
[![Twitter](https://img.shields.io/badge/twitter-%231DA1F2.svg?&style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/uguraltnsy)
[![Instagram](https://img.shields.io/badge/instagram-%23E4405F.svg?&style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/ugur.altnsy)
[![Linkedin](https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/uğur-altınsoy/)
[![Google Play](https://img.shields.io/badge/Google%20Play-414141?logo=google-play&logoColor=white&style=for-the-badge)](https://play.google.com/store/apps/developer?id=DeepLab&hl=tr)
