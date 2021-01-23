package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRecylcerAdapter extends RecyclerView.Adapter<CurrencyRecylcerAdapter.CurrViewHolder> {
    private List<Currency> currencies = new ArrayList<>();

    CurrencyRecylcerAdapter(List<Currency> list) {
        currencies = list;
    }

    @NonNull
    @Override
    public CurrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View currencyView = inflater.inflate(R.layout.currency_item, parent, false);
        return new CurrViewHolder(currencyView);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrViewHolder holder, int position) {
        holder.bindData(currencies.get(position));
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class CurrViewHolder extends RecyclerView.ViewHolder {
        public TextView countryName;
        public TextView currencyValue;
        public TextView currencyInitilas;
        public TextView currencyDiff;
        public ImageView currencyDiffIcon;

        public CurrViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.currency_name);
            currencyValue = itemView.findViewById(R.id.currency_value);
            currencyDiff = itemView.findViewById(R.id.currency_diff);
            currencyInitilas = itemView.findViewById(R.id.currency_initials);
            currencyDiffIcon = itemView.findViewById(R.id.diff_icon);
        }

        void bindData(Currency currency) {
            countryName.setText(currency.getCountry());
            currencyValue.setText(currency.getAmount());
            currencyDiff.setText(currency.getDifference());
            currencyInitilas.setText(currency.getInitials());
            Glide.with(itemView).load(currency.getIconUrl()).into(currencyDiffIcon);
        }
    }
}
