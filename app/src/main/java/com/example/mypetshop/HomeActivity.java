package com.example.mypetshop;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mypetshop.databinding.ActivityHomeBinding;
import com.example.mypetshop.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    CardView commit, pet, nutri, shelter, care, vac, regis;
    Dialog mdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        commit = (CardView) findViewById(R.id.commit);
        pet = (CardView) findViewById(R.id.pet);
        nutri = (CardView) findViewById(R.id.nutri);
        shelter = (CardView) findViewById(R.id.shelter);
        care = (CardView) findViewById(R.id.care);
        vac = (CardView) findViewById(R.id.vac);
        regis = (CardView) findViewById(R.id.regis);
        mdialog = new Dialog(this);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog layout and ListView
                mdialog.setContentView(R.layout.dialog);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mdialog.show();

                ListView listView = mdialog.findViewById(R.id.listView);

                ImageView imageView = mdialog.findViewById(R.id.img);
                imageView.setImageResource(R.drawable.commit);

                // Set up ListView adapter and data
                ArrayList<ListItem> items = new ArrayList<>();
                items.add(new ListItem("Are you prepared?", R.drawable.commit));
                items.add(new ListItem("Can you provide?", R.drawable.commit));

                ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click, for example, navigate to item details page
                        ListItem selectedItem = items.get(position);
                        Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                        intent.putExtra("selectedItemName", selectedItem.getName());
                        intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                        intent.putExtra("titleData", "Commitment"); // Pass the title data

                        // Customize additional data based on the clicked item
                        String additionalData = ""; // Initialize additional data
                        switch (position) {
                            case 0:
                                additionalData = "Owning a pet involves a long-term commitment. Dogs and cats can live for up to 15 years or more, so it’s crucial to be prepared for their entire lifespan.";
                                break;
                            case 1:
                                additionalData = "Consider if you can provide consistent care and attention. You will also need to prepare your financial situation because your pet will need quality food, healthcare, etc.";
                                break;
                        }
                        intent.putExtra("additionalData", additionalData);

                        startActivity(intent);
                    }
                });
            }
        });


        pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog layout and ListView
                mdialog.setContentView(R.layout.dialog);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mdialog.show();

                ListView listView = mdialog.findViewById(R.id.listView);

                ImageView imageView = mdialog.findViewById(R.id.img);
                imageView.setImageResource(R.drawable.commit);

                // Set up ListView adapter and data
                ArrayList<ListItem> items = new ArrayList<>();
                items.add(new ListItem("Shih Tzu", R.drawable.pet));
                items.add(new ListItem("Maltese", R.drawable.pet));
                items.add(new ListItem("Shiba Inu", R.drawable.pet));
                items.add(new ListItem("Chow chow", R.drawable.pet));
                items.add(new ListItem("Poodle", R.drawable.pet));
                items.add(new ListItem("Golden Retriever", R.drawable.pet));
                items.add(new ListItem("Labrador", R.drawable.pet));
                items.add(new ListItem("Samoyed", R.drawable.pet));
                items.add(new ListItem("Chihuahua", R.drawable.pet));

                ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click, for example, navigate to item details page
                        ListItem selectedItem = items.get(position);
                        Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                        intent.putExtra("selectedItemName", selectedItem.getName());
                        intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                        intent.putExtra("titleData", "Commitment"); // Pass the title data

                        // Customize additional data based on the clicked item
                        String additionalData = ""; // Initialize additional data
                        switch (position) {
                            case 0:
                                additionalData = "4 Females 5 Males. 3mos old. Choco liver line. Very sweet and playful." /n + "Please contact 09123654789";
                                break;
                            case 1:
                                additionalData = "2 Females 3 Males Available. Quality purebred maltese. Please contact 09123654789";
                                break;
                            case 2:
                                additionalData = "";
                                break;
                            case 3:
                                additionalData = "";
                                break;
                            case 4:
                                additionalData = "";
                                break;
                            case 5:
                                additionalData = "";
                                break;
                            case 6:
                                additionalData = "";
                                break;
                            case 7:
                                additionalData = "";
                                break;
                            case 8:
                                additionalData = "";
                                break;

                        }
                        intent.putExtra("additionalData", additionalData);

                        startActivity(intent);
                    }
                });

            }
        });

        nutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog layout and ListView
                mdialog.setContentView(R.layout.dialog);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mdialog.show();

                ListView listView = mdialog.findViewById(R.id.listView);

                ImageView imageView = mdialog.findViewById(R.id.img);
                imageView.setImageResource(R.drawable.commit);

                // Set up ListView adapter and data
                ArrayList<ListItem> items = new ArrayList<>();
                items.add(new ListItem("Item 1", R.drawable.pet));
                items.add(new ListItem("Item 2", R.drawable.pet));
                items.add(new ListItem("Item 3", R.drawable.pet));

                ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click, for example, navigate to item details page
                        ListItem selectedItem = items.get(position);
                        Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                        intent.putExtra("selectedItemName", selectedItem.getName());
                        intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                        intent.putExtra("titleData", "Commitment"); // Pass the title data

                        // Customize additional data based on the clicked item
                        String additionalData = ""; // Initialize additional data
                        switch (position) {
                            case 0:
                                additionalData = "";
                                break;
                            case 1:
                                additionalData = "";
                                break;
                        }
                        intent.putExtra("additionalData", additionalData);

                        startActivity(intent);
                    }
                });

            }
        });

        shelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog layout and ListView
                mdialog.setContentView(R.layout.dialog);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mdialog.show();

                ListView listView = mdialog.findViewById(R.id.listView);

                ImageView imageView = mdialog.findViewById(R.id.img);
                imageView.setImageResource(R.drawable.commit);

                // Set up ListView adapter and data
                ArrayList<ListItem> items = new ArrayList<>();
                items.add(new ListItem("Item 1", R.drawable.pet));
                items.add(new ListItem("Item 2", R.drawable.pet));
                items.add(new ListItem("Item 3", R.drawable.pet));

                ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click, for example, navigate to item details page
                        ListItem selectedItem = items.get(position);
                        Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                        intent.putExtra("selectedItemName", selectedItem.getName());
                        intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                        intent.putExtra("titleData", "Commitment"); // Pass the title data

                        // Customize additional data based on the clicked item
                        String additionalData = ""; // Initialize additional data
                        switch (position) {
                            case 0:
                                additionalData = "";
                                break;
                            case 1:
                                additionalData = "";
                                break;
                        }
                        intent.putExtra("additionalData", additionalData);

                        startActivity(intent);
                    }
                });

            }
        });

        care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog layout and ListView
                mdialog.setContentView(R.layout.dialog);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mdialog.show();

                ListView listView = mdialog.findViewById(R.id.listView);

                ImageView imageView = mdialog.findViewById(R.id.img);
                imageView.setImageResource(R.drawable.commit);

                // Set up ListView adapter and data
                ArrayList<ListItem> items = new ArrayList<>();
                items.add(new ListItem("Item 1", R.drawable.pet));
                items.add(new ListItem("Item 2", R.drawable.pet));
                items.add(new ListItem("Item 3", R.drawable.pet));

                ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click, for example, navigate to item details page
                        ListItem selectedItem = items.get(position);
                        Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                        intent.putExtra("selectedItemName", selectedItem.getName());
                        intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                        intent.putExtra("titleData", "Commitment"); // Pass the title data

                        // Customize additional data based on the clicked item
                        String additionalData = ""; // Initialize additional data
                        switch (position) {
                            case 0:
                                additionalData = "";
                                break;
                            case 1:
                                additionalData = "";
                                break;
                        }
                        intent.putExtra("additionalData", additionalData);

                        startActivity(intent);
                    }
                });

            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog layout and ListView
                mdialog.setContentView(R.layout.dialog);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mdialog.show();

                ListView listView = mdialog.findViewById(R.id.listView);

                ImageView imageView = mdialog.findViewById(R.id.img);
                imageView.setImageResource(R.drawable.commit);

                // Set up ListView adapter and data
                ArrayList<ListItem> items = new ArrayList<>();
                items.add(new ListItem("Item 1", R.drawable.pet));
                items.add(new ListItem("Item 2", R.drawable.pet));
                items.add(new ListItem("Item 3", R.drawable.pet));

                ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click, for example, navigate to item details page
                        ListItem selectedItem = items.get(position);
                        Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                        intent.putExtra("selectedItemName", selectedItem.getName());
                        intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                        intent.putExtra("titleData", "Commitment"); // Pass the title data

                        // Customize additional data based on the clicked item
                        String additionalData = ""; // Initialize additional data
                        switch (position) {
                            case 0:
                                additionalData = "";
                                break;
                            case 1:
                                additionalData = "";
                                break;
                        }
                        intent.putExtra("additionalData", additionalData);

                        startActivity(intent);
                    }
                });

            }
        });

        vac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog layout and ListView
                mdialog.setContentView(R.layout.dialog);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mdialog.show();

                ListView listView = mdialog.findViewById(R.id.listView);

                ImageView imageView = mdialog.findViewById(R.id.img);
                imageView.setImageResource(R.drawable.commit);

                // Set up ListView adapter and data
                ArrayList<ListItem> items = new ArrayList<>();
                items.add(new ListItem("Item 1", R.drawable.pet));
                items.add(new ListItem("Item 2", R.drawable.pet));
                items.add(new ListItem("Item 3", R.drawable.pet));

                ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click, for example, navigate to item details page
                        ListItem selectedItem = items.get(position);
                        Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                        intent.putExtra("selectedItemName", selectedItem.getName());
                        intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                        intent.putExtra("titleData", "Commitment"); // Pass the title data

                        // Customize additional data based on the clicked item
                        String additionalData = ""; // Initialize additional data
                        switch (position) {
                            case 0:
                                additionalData = "";
                                break;
                            case 1:
                                additionalData = "";
                                break;
                        }
                        intent.putExtra("additionalData", additionalData);

                        startActivity(intent);
                    }
                });

            }
        });

    }
}