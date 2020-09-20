package com.example.startactivityproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HealthyDrinks extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    ArrayList<ExampleItem> exampleList;
    ArrayList<String> lista;
    ArrayList<String> steps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_drinks);


        createList();
        buildRecyclerView();

    }

    private void createList() {
        exampleList=new ArrayList<>();
        lista=new ArrayList<>();
        lista.add("1 cup almond milk");
        lista.add("1/2 cup coconut milk");
        lista.add("1 cup blueberries");
        lista.add("2 bananas");
        lista.add("2 teaspoons flaxseeds ");
        lista.add("Banana is high in fiber, so it is great for weight-loss and good health. A good source of potassium, so it is good for your heart. it contains a high level of tryptophan which is beneficial in preventing depression." +
                "Blueberries contain powerful compounds called flavonoids antioxidants called anthocyanins which fight against free radicals in the body.");
        exampleList.add(new ExampleItem(R.drawable.eden,"Blueberry Banana","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("2 tea bags");
        lista.add("8 ounces crushed pineapples in juice");
        lista.add("1 banana");
        lista.add("1 tablespoon honey");
        lista.add("1 cup ice cubes");
        lista.add("Bananas are respectable sources of vitamin C.Honey contains a number of antioxidants, including phenolic compounds like flavonoids.");
        exampleList.add(new ExampleItem(R.drawable.tri,"Tropical Tea","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add(null);
        lista.add("2 cups breyers natural strawberry ice cream");
        lista.add("1 cup 2% milk");
        lista.add("1 teaspoon vanilla extract");
        lista.add(null);
        lista.add("Strawberries are bright red, juicy, and sweet. They're an excellent source of vitamin C and manganese and also contain decent amounts of folate (vitamin B9) and potassium." +
                "They are very rich in antioxidants and plant compounds, which may have benefits for heart health and blood sugar control");
        exampleList.add(new ExampleItem(R.drawable.cetiri,"Strawberry Shakes","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("1 cup almond milk");
        lista.add("2 bananas (medium ripe, frozen)");
        lista.add("2 oranges (medium, peeled and broken into pegs)");
        lista.add("1/2 teaspoon vanilla");
        lista.add(null);
        lista.add("Oranges are an excellent source of vitamin C. One orange offers 116.2 per cent of the daily value for vitamin C." +
                "Vitamin C, which is also vital for the proper function of a healthy immune system, is good for preventing colds and preventing recurrent ear infections.");
        exampleList.add(new ExampleItem(R.drawable.pet,"Orange Creamsicle","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("1 1/2 cups unsweetened vanilla almond milk");
        lista.add("1/2 avocado (pitted and scooped out.)");
        lista.add("1 frozen banana");
        lista.add("2 tablespoons raw cacao powder");
        lista.add("1 tablespoon honey");
        lista.add("Avocados are a great source of vitamins C, E, K, and B-6, as well as riboflavin, niacin, folate, pantothenic acid, magnesium, and potassium. They also provide lutein, " +
                "beta-carotene, and omega-3 fatty acids. Although most of the calories in an avocado come from fat, don't shy away!");
        exampleList.add(new ExampleItem(R.drawable.sest,"Chocolate Avocado","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("1 cup spinach");
        lista.add("1 cup kale");
        lista.add("1 cup frozen fruit");
        lista.add("1/2 lemon");
        lista.add("1/2 cup water");
        lista.add("Spinach is an excellent source of vitamin K, vitamin A, vitamin C and folate as well as being a good source of manganese, magnesium, iron and vitamin B2. Vitamin K is important for maintaining bone health and it is difficult to find vegetables richer in vitamin K than spinach.");
        exampleList.add(new ExampleItem(R.drawable.sedum,"Green Smoothie","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("1 cup mango (chopped ripe)");
        lista.add("1/2 cup milk (or almond milk)");
        lista.add("1/2 cup ice cubes");
        lista.add("1/4 cup plain yogurt");
        lista.add("1 tablespoon honey");
        lista.add("Mangoes could help facilitate healthy digestion. You would be surprised to know that an average sized mango contains upto two-third of the daily recommended intake of vitamin C." +
                " Including mangoes in the diet may also help promote your eye health. Mangoes are rich in beta-carotene that helps in the production of Vitamin A.");
        exampleList.add(new ExampleItem(R.drawable.osum,"Tropical Mango","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista=new ArrayList<>();
        lista.add("1/2 cup greek yogurt");
        lista.add("3/4 cup frozen strawberries");
        lista.add("1 cup skim milk (or milk of choice)");
        lista.add("1 tablespoon unsweetened dark cocoa powder");
        lista.add("1/2 cup ice (only if using fresh berries)");
        lista.add("Quality dark chocolate is rich in fiber, iron, magnesium, copper, manganese and a few other minerals.Strawberries are a good source of vitamin C, manganese, folate (vitamin B9), and potassium. They contain small amounts of several other vitamins and minerals.");
        exampleList.add(new ExampleItem(R.drawable.devet,"Dark Chocolate Strawberry","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("3/4 cup nonfat greek yogurt");
        lista.add("2 cups bananas (frozen sliced)");
        lista.add("1 teaspoon vanilla extract");
        lista.add("1/4 cup vanilla protein powder");
        lista.add("2 cups milk");
        lista.add("Bananas are rich in fiber, antioxidants and several nutrients. A medium-sized banana has about 105 calories." +
                "Bananas can help moderate blood sugar levels after meals and may reduce appetite by slowing stomach emptying.");
        exampleList.add(new ExampleItem(R.drawable.deset,"Banana Protein Shake","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("2 cups frozen blueberries");
        lista.add("1/2 cup walnut pieces");
        lista.add("1/2 cup baby spinach");
        lista.add("3/4 cup almond milk");
        lista.add("1/2 cup apple juice");
        lista.add("The resulting smoothie is sweet, creamy, yummy, and literally food for your brain!");
        exampleList.add(new ExampleItem(R.drawable.dva,"Blueberry Brain","Click for more...",lista, steps));
        lista=new ArrayList<>();
        lista.add("5 fresh lemons");
        lista.add("1/3 cup honey");
        lista.add("4 cups cold water ");
        lista.add("lemon wedges");
        lista.add(null);
        lista.add("Lemons are high in heart-healthy vitamin C and several beneficial plant compounds that may lower cholesterol." +
                "Lemon juice may help prevent kidney stones. However, more quality research is needed.Lemons contain vitamin C and citric acid, which help you absorb non-heme iron from plants. This may prevent anemia." +
                "The soluble fiber in lemons could help improve digestive health. ");
        exampleList.add(new ExampleItem(R.drawable.edinaeset,"3-Ingredient Lemonade","Click for more...",lista, steps));


    }

    private void buildRecyclerView() {
        mRecyclerView=findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position) {
                Intent intentStart=new Intent(getApplicationContext(),DetailsActivity.class);
                intentStart.putExtra("title",exampleList.get(position).getmText1());
                intentStart.putExtra("image",exampleList.get(position).getmImageResource());
                intentStart.putExtra("list",exampleList.get(position).getLista());
                startActivity(intentStart);
            }
        });
    }

    //kopcinjata u toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ILogOut:
                logOut();
                break;
            case R.id.IHome:
                Intent intentHome=new Intent(getApplicationContext(),LoggedinActivity.class);
                startActivity(intentHome);
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.alert_dark_frame)
                .setTitle("Logout Alert").setMessage("Are you sure you want to logout?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        LoginManager.getInstance().logOut();
                    }
                }).setNegativeButton("NO",null).show();
    }
}
