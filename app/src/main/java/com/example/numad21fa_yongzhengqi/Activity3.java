package com.example.numad21fa_yongzhengqi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    private ArrayList<Links> itemList = new ArrayList<>();

    private EditText itemName;
    private EditText itemLink;
    private AlertDialog alertDialog;
    private RecyclerView recyclerView;
    private RviewAdapter rviewAdapter;
    private RecyclerView.LayoutManager rLayoutManger;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init(savedInstanceState);

        FloatingActionButton addButton;
        addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(v -> addItem());
        createDialog();
        createRecyclerView();
        rviewAdapter.setOnLinkClickListener(position -> itemList.get(position).createLink(this));
    }

    public void createDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.dialog, null);

        itemName = view.findViewById(R.id.link_name_input);

        itemLink = view.findViewById(R.id.link_url_input);

        final AlertDialog.Builder builder = new AlertDialog.Builder(Activity3.this);
        builder.setTitle("Input Name and Link URL");
        builder.setView(view);

        builder.setCancelable(false)
                .setPositiveButton("OK", (dialog1, which) -> {
                    Links links = new Links(itemName.getText().toString(), itemLink.getText().toString());
                    if (!links.isValid()) {
                        Snackbar.make(recyclerView, "Please Enter a valid URL!", Snackbar.LENGTH_LONG).show();
                    } else {
                        itemList.add(0, links);
                        rviewAdapter.notifyDataSetChanged();
                        Snackbar.make(recyclerView, "the link was successfully created", Snackbar.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        alertDialog = builder.create();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        int size = itemList == null ? 0 : itemList.size();
        outState.putInt(NUMBER_OF_ITEMS, size);

        // Need to generate unique key for each item
        for (int i = 0; i < size; i++) {
            outState.putString(KEY_OF_INSTANCE + i + "0", itemList.get(i).linkName);
            outState.putString(KEY_OF_INSTANCE + i + "1", itemList.get(i).url);
        }
        super.onSaveInstanceState(outState);
    }

    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void initialItemData(Bundle savedInstanceState) {
        ArrayList<Links> list = new ArrayList<>();
    }

    private void createRecyclerView() {
        rLayoutManger = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        rviewAdapter = new RviewAdapter(itemList);

        recyclerView.setAdapter(rviewAdapter);
        recyclerView.setLayoutManager(rLayoutManger);


    }

    public void addItem() {
        itemName.getText();
        itemLink.setText(getString(R.string.Http));
        itemName.requestFocus();
        alertDialog.show();
    }

}