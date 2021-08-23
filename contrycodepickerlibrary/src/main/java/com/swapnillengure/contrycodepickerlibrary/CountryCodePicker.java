package com.swapnillengure.contrycodepickerlibrary;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountryCodePicker {
    public static void PickerInit(Activity activity,CountryClickListener listener){
        CountryCodeAdapter adapter = new CountryCodeAdapter();;
        final View loc = activity.getLayoutInflater().inflate(R.layout.bottomsheet_phone_code, null);
        final BottomSheetDialog locBottomSheetDialog = new BottomSheetDialog(activity, R.style.BottomSheetDialog);
        locBottomSheetDialog.setContentView(loc);
        locBottomSheetDialog.setCancelable(false);
        locBottomSheetDialog.show();
        EditText searchField = (EditText) locBottomSheetDialog.findViewById(R.id.editText_search);
        Button dobSubmit = (Button) locBottomSheetDialog.findViewById(R.id.loc_submit);
        RecyclerView recyclerView = (RecyclerView) locBottomSheetDialog.findViewById(R.id.recycler_countryDialog);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);
        adapter.setMovieList(activity, Arrays.asList(Country.myListData), listener);

        dobSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locBottomSheetDialog.hide();
            }
        });

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.d("ssssssssssssssss", s.toString());
                // filter your list from your input
                if (s.length() == 0) {
                    adapter.setMovieList(activity, Arrays.asList(Country.myListData), listener);
                } else {
                    List<CountryData> colorsList = new LinkedList<CountryData>();
                    int im = 0;
                    for (CountryData sk : Country.myListData) {
                        if (sk.getDescription().toLowerCase().contains(s.toString().toLowerCase())) {
                            colorsList.add(sk);
                            im++;
                        }
                    }
                    adapter.setMovieList(activity, colorsList, listener);
                }
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });
    }
}
