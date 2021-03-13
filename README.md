# StockChartSample

An android app that can parse the files 
([responseQuotesMonth.json](/app/src/main/assets/responseQuotesMonth.json), 
[responseQuotesWeek.json](/app/src/main/assets/responseQuotesWeek.json)) 
and draw a chart that compares performance of 3 stocks (AAPL, MSFT and SPY) for the last week (Hourly data) and last month (Daily data) based on **Open** or Close data.

Also the app can draw a [candlestick chart](https://www.investopedia.com/trading/candlestick-charting-what-is-it/) for any of the stocks (**AAPL**, MSFT and SPY).

### Used libraries
- [gson](https://github.com/google/gson)
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)
- androidx (appcompat, navigation, lifecycle etc)

### How to calculate performance and compare
Let's say for stock XYZ, the first day price is 100, and the second day price is 120 and third day price is 110. So the performance data would be 0%, 20% ,10%. 
