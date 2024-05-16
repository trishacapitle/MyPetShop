package com.example.mypetshop;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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

        commit = findViewById(R.id.commit);
        pet = findViewById(R.id.pet);
        nutri = findViewById(R.id.nutri);
        shelter = findViewById(R.id.shelter);
        care = findViewById(R.id.care);
        vac = findViewById(R.id.vac);
        regis = findViewById(R.id.regis);
        mdialog = new Dialog(this);

        commit.setOnClickListener(v -> {
            // Initialize dialog layout and ListView
            mdialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(mdialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

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

            listView.setOnItemClickListener((parent, view, position, id) -> {
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
            });
        });


        pet.setOnClickListener(v -> {
            // Initialize dialog layout and ListView
            mdialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(mdialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            mdialog.show();

            ListView listView = mdialog.findViewById(R.id.listView);

            ImageView imageView = mdialog.findViewById(R.id.img);
            imageView.setImageResource(R.drawable.pet);

            // Set up ListView adapter and data
            ArrayList<ListItem> items = new ArrayList<>();
            items.add(new ListItem("Shih Tzu", R.drawable.pet));
            items.add(new ListItem("Maltese", R.drawable.pet));
            items.add(new ListItem("Shiba Inu", R.drawable.pet));
            items.add(new ListItem("Chow chow", R.drawable.pet));
            items.add(new ListItem("Poodle", R.drawable.pet));

            ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                // Handle item click, for example, navigate to item details page
                ListItem selectedItem = items.get(position);
                Intent intent = new Intent(HomeActivity.this, DetailedView.class);
                intent.putExtra("selectedItemName", selectedItem.getName());
                intent.putExtra("selectedItemImage", selectedItem.getImageResourceId());

                intent.putExtra("titleData", "Commitment"); // Pass the title data

                Random random = new Random();
                int numOfFemales = random.nextInt(5); // Random number of females between 0 and 4
                int numOfMales = random.nextInt(5);
                // Customize additional data based on the clicked item
                String additionalData = ""; // Initialize additional data
                switch (position) {

                    case 0:
                        additionalData = numOfFemales + " Females " + numOfMales + " Males Available. Adorable Shih tzu puppies ready for their forever homes. These puppies are purebred with excellent lineage. Contact: 09123654789";
                        break;
                    case 1:
                        additionalData = numOfFemales + " Females " + numOfMales + " Males Available. Adorable Maltese puppies ready for their forever homes. These puppies are purebred with excellent lineage. Contact: 09123654789";
                        break;
                    case 2:
                        additionalData = numOfFemales + " Females " + numOfMales + " Males Available. Adorable Shiba Inu puppies ready for their forever homes. These puppies are purebred with excellent lineage. Contact: 09123654789";
                        break;
                    case 3:
                        additionalData = numOfFemales + " Females " + numOfMales + " Males Available. Adorable Chow chow puppies ready for their forever homes. These puppies are purebred with excellent lineage. Contact: 09123654789";
                        break;
                    case 4:
                        additionalData = numOfFemales + " Females " + numOfMales + " Males Available. Adorable Poodle puppies ready for their forever homes. These puppies are purebred with excellent lineage. Contact: 09123654789";
                        break;
                }
                intent.putExtra("additionalData", additionalData);

                startActivity(intent);
            });

        });

        nutri.setOnClickListener(v -> {
            // Initialize dialog layout and ListView
            mdialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(mdialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            mdialog.show();

            ListView listView = mdialog.findViewById(R.id.listView);

            ImageView imageView = mdialog.findViewById(R.id.img);
            imageView.setImageResource(R.drawable.nutrition);

            // Set up ListView adapter and data
            ArrayList<ListItem> items = new ArrayList<>();
            items.add(new ListItem("Dry Dog Food", R.drawable.nutrition));
            items.add(new ListItem("Cat Dry Food", R.drawable.nutrition));
            items.add(new ListItem("Probiotics", R.drawable.nutrition));
            items.add(new ListItem("Vitamins", R.drawable.nutrition));
            items.add(new ListItem("Supplements", R.drawable.nutrition));

            ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
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
                        additionalData = "Price: 189php (on sale)\n" +
                                "Description: This formula provides a balanced blend of duck, pumpkin, and quinoa to support your dog’s health and well-being. It’s grain-free and suitable for adult dogs";
                        break;
                    case 1:
                        additionalData = "Price: 199php\n" +
                                "Description: This supplement contains omega-3 and omega-6 fatty acids, dietary fiber, and phytonutrients to support skin, coat, digestion, and immunity in cats.";
                        break;
                    case 2:
                        additionalData = "Price: 189php\n" + "Help improve digestive health.";
                        break;
                    case 3:
                        additionalData = "Price: 100php\n" + "Ensure your cat gets essential nutrients.";
                        break;
                    case 4:
                        additionalData = "Price: 120php\n" + "Boost immune function.";
                        break;
                }
                intent.putExtra("additionalData", additionalData);

                startActivity(intent);
            });

        });

        shelter.setOnClickListener(v -> {
            // Initialize dialog layout and ListView
            mdialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(mdialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            mdialog.show();

            ListView listView = mdialog.findViewById(R.id.listView);

            ImageView imageView = mdialog.findViewById(R.id.img);
            imageView.setImageResource(R.drawable.shelter);

            // Set up ListView adapter and data
            ArrayList<ListItem> items = new ArrayList<>();
            items.add(new ListItem("Stainless steel Dog Cage", R.drawable.shelter));
            items.add(new ListItem("Cat Condos", R.drawable.shelter));
            items.add(new ListItem("Blankets and Sheets", R.drawable.shelter));

            ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
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
                        additionalData = "Price: 1999php\n" + "These are durable and easy-to-clean enclosures for dogs. They come in various sizes and configurations to accommodate different breeds and sizes. Stainless steel ensures longevity and hygiene";
                        break;
                    case 1:
                        additionalData = "Price: 789php\n" + "Deluxe cat condos can be customized for optimal use in any type of facility. They are cost-effective and suitable for luxury boarding facilities, animal shelters, veterinary clinics, and more";
                        break;
                    case 2:
                        additionalData = "Price: 95php\n" + "Soft bedding materials for animals to rest comfortably. These can be laundered and reused";
                        break;
                }
                intent.putExtra("additionalData", additionalData);

                startActivity(intent);
            });

        });

        care.setOnClickListener(v -> {
            // Initialize dialog layout and ListView
            mdialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(mdialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            mdialog.show();

            ListView listView = mdialog.findViewById(R.id.listView);

            ImageView imageView = mdialog.findViewById(R.id.img);
            imageView.setImageResource(R.drawable.care);

            // Set up ListView adapter and data
            ArrayList<ListItem> items = new ArrayList<>();
            items.add(new ListItem("Heartgard Plus", R.drawable.care));
            items.add(new ListItem("Frontline Plus", R.drawable.care));
            items.add(new ListItem("Nexgard", R.drawable.care));

            ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
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
                        additionalData = "A trusted heartworm preventive.";
                        break;
                    case 1:
                        additionalData = "A popular flea and tick control solution.";
                        break;
                    case 2:
                        additionalData = "Nexgard: Chewable tablets for flea and tick prevention";
                        break;
                }
                intent.putExtra("additionalData", additionalData);

                startActivity(intent);
            });

        });

        regis.setOnClickListener(v -> {
            // Initialize dialog layout and ListView
            mdialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(mdialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            mdialog.show();

            ListView listView = mdialog.findViewById(R.id.listView);

            ImageView imageView = mdialog.findViewById(R.id.img);
            imageView.setImageResource(R.drawable.regis);

            // Set up ListView adapter and data
            ArrayList<ListItem> items = new ArrayList<>();
            items.add(new ListItem("Register Your Pet", R.drawable.regis));
            items.add(new ListItem("Pet Online Registration", R.drawable.regis));

            ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
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
                        additionalData = "Pet registration is crucial for reuniting lost pets with their owners, ensuring they are vaccinated, managing animal populations, and preventing illegal breeding and sales.";
                        break;
                    case 1:
                        additionalData = "https://petdentity.com.ph/pet-registration/ \n" + "Petdentity offers an annual pet registration system that not only protects you and your pets but also helps our Government achieve the Rabies-Free Philippines 2020 Campaign";
                        break;
                }
                intent.putExtra("additionalData", additionalData);

                startActivity(intent);
            });

        });

        vac.setOnClickListener(v -> {
            // Initialize dialog layout and ListView
            mdialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(mdialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            mdialog.show();

            ListView listView = mdialog.findViewById(R.id.listView);

            ImageView imageView = mdialog.findViewById(R.id.img);
            imageView.setImageResource(R.drawable.vac);

            // Set up ListView adapter and data
            ArrayList<ListItem> items = new ArrayList<>();
            items.add(new ListItem("Pet Vaccination", R.drawable.vac));
            items.add(new ListItem("Book Online Appointment", R.drawable.vac));

            ListAdapter adapter = new com.example.mypetshop.ListAdapter(HomeActivity.this, items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
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
                        additionalData = "Pet vaccination is crucial for protecting against preventable diseases and ensuring the health and well-being of pets.";
                        break;
                    case 1:
                        additionalData = "Vets In Practice Inc.: vetsinpractice.ph\n" +
                                "Location: 63 Maysilo Circle cor Boni Ave., Makati, National Capital Region, 1550\n" +
                                "Services: Comprehensive range of veterinary care with a focus on quality. Open hours vary.";
                        break;
                }
                intent.putExtra("additionalData", additionalData);

                startActivity(intent);
            });

        });

    }
}