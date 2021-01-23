package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Currency> list = new ArrayList<>();
    RecyclerView currencyRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencyRecycler = findViewById(R.id.currency_list);
        getData();
        CurrencyRecylcerAdapter currencyRecylcerAdapter = new CurrencyRecylcerAdapter(list);

        currencyRecycler.setAdapter(currencyRecylcerAdapter);
    }

    private void getData() {
        Thread t = new Thread(() -> {
            try {
                Document doc = null;
                doc = Jsoup.connect("http://www.nbg.ge/rss.php").get();
                Element desc = doc.select("description").get(1);
                String htmlTable = desc.text().replace("<![CDATA[ ", "");
                htmlTable = htmlTable.replace(" ]]>", "");
                Document doc1 = Jsoup.parse(htmlTable);
                Elements tableData = doc1.getElementsByTag("td");
                Currency currency = new Currency();
                for (int i = 0; i < tableData.size(); i++) {
                    switch (i % 5) {
                        case 0:
                            currency = new Currency();
                            currency.setInitials(tableData.get(i).text());
                            break;
                        case 1:
                            currency.setCountry(tableData.get(i).text());
                            break;
                        case 2:
                            currency.setAmount(tableData.get(i).text());
                            break;
                        case 3:
                            String image = tableData.get(i).getElementsByTag("img").get(0).attr("src");
                            currency.setIconUrl(image);
                            break;
                        case 4:
                            currency.setDifference(tableData.get(i).text());
                            list.add(currency);
                            Log.d("-------", currency.toString());
                            break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}