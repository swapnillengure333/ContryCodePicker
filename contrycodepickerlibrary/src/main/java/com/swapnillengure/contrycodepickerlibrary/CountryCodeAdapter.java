package com.swapnillengure.contrycodepickerlibrary;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class CountryCodeAdapter extends RecyclerView.Adapter<CountryCodeAdapter.ViewHolder> implements Filterable {
   private List<CountryData> countryList;
    private List<CountryData> countryListFiltered;
    int row_index = -1;
    CountryClickListener listener;
    // RecyclerView recyclerView;
    private Context context;
    public void setMovieList(Context context, final List<CountryData> countryList, CountryClickListener listener) {
        this.context = context;
        this.listener = listener;
        if (this.countryList == null) {
            this.countryList = countryList;
            this.countryListFiltered = countryList;
            notifyItemChanged(0, countryListFiltered.size());
        } else {
            final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return CountryCodeAdapter.this.countryList.size();
                }

                @Override
                public int getNewListSize() {
                    return countryList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return CountryCodeAdapter.this.countryList.get(oldItemPosition).getDescription() == countryList.get(newItemPosition).getCode();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    CountryData newMovie = CountryCodeAdapter.this.countryList.get(oldItemPosition);

                    CountryData oldMovie = countryList.get(newItemPosition);

                    return newMovie.getDescription() == oldMovie.getDescription();
                }
            });
            this.countryList = countryList;
            this.countryListFiltered = countryList;
            result.dispatchUpdatesTo(this);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_country_code, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    countryListFiltered = countryList;
                } else {
                    List<CountryData> filteredList = new ArrayList<>();
                    for (CountryData row : countryList) {
                   if (row.getDescription().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    countryListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = countryListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                countryListFiltered = (ArrayList<CountryData>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CountryData myListData = countryList.get(position);
        holder.textView.setText(countryList.get(position).getDescription());
        holder.codeText.setText("+"+countryList.get(position).getCode());
        holder.imageView.setImageResource(countryList.get(position).getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          //      Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
                row_index=position;
                listener.onItemClick(countryList.get(position).getDescription(),countryList.get(position).getCode());
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            holder.relativeLayout.setBackground(ContextCompat.getDrawable(holder.relativeLayout.getContext(), R.drawable.button_background_v ));
            holder.textView.setTextColor(Color.parseColor("#FFFFFF"));
            holder.codeText.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.textView.setTextColor(Color.parseColor("#D2D2D2"));
            holder.codeText.setTextColor(Color.parseColor("#000000"));
        }
    }


    @Override
    public int getItemCount() {
        if(countryList!= null){
            return countryListFiltered.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;public TextView codeText;
        public LinearLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.codeText = (TextView) itemView.findViewById(R.id.textCode);
            relativeLayout = (LinearLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}