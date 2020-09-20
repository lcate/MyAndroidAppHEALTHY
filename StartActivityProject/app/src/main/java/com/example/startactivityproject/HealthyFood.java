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

public class HealthyFood extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ExampleItem> exampleList;
    ArrayList<String> lista;
    ArrayList<String> steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_food);


        createList();
        buildRecyclerView();
    }

    private void createList() {
        exampleList = new ArrayList<>();
        lista = new ArrayList<>();
        lista.add("Four 4-ounce boneless, skinless chicken breast cutlets");
        lista.add("Kosher salt and freshly ground black pepper");
        lista.add("1/3 cup whole wheat flour");
        lista.add("1 1/2 tablespoons extra-virgin olive oil");
        lista.add("3/4 cup low-sodium chicken broth ");
        lista.add("1/3 cup sun-dried tomatoes (not packed in oil; not rehydrated), finely chopped or very thinly sliced");
        lista.add("1/2 teaspoon finely chopped fresh rosemary");
        lista.add("10 ounces white button or cremini (baby bella) mushrooms, sliced");
        lista.add("1/3 cup sweet marsala wine");
        lista.add("2 teaspoons unsalted butter ");
        lista.add("1 to 2 tablespoons roughly chopped fresh flat-leaf parsley");
        steps=new ArrayList<>();
        steps.add("1. Place the chicken cutlets between 2 pieces of plastic wrap and pound with a meat mallet until about 1/3 inch thick. Sprinkle with 1/4 teaspoon salt and 1/4 teaspoon pepper.");
        steps.add("2. Dredge the chicken in the flour to fully coat, shaking off any excess. Add the chicken to the skillet and fry until fully cooked and golden brown, about 4 minutes per side. ");
        steps.add("3. Add 1/2 cup of the broth, the sun-dried tomatoes and rosemary to any remaining drippings in the skillet and cook.1/4 teaspoon salt and 1/2 teaspoon pepper and cook until the mushrooms are soft, about 5 minutes. Add the marsala and bring to a boil. Add the remaining 1/4 cup broth and the butter and simmer until the butter is fully melted, about 30 seconds.");
        steps.add("4. Spoon the mushroom mixture and sauce over the chicken, sprinkle with the parsley and serve.");
        exampleList.add(new ExampleItem(R.drawable.herbed, "Herbed Chicken Marsala", "Click for more...", lista,steps));

        lista = new ArrayList<>();
        lista.add("3 whole ancho chiles");
        lista.add("3 whole pasilla chiles");
        lista.add("4 cloves garlic, unpeeled");
        lista.add("2 to 3 chipotles in adobo sauce");
        lista.add("1/2 medium white onion, roughly chopped");
        lista.add("3 tablespoons extra-virgin olive oil");
        lista.add("2 tablespoons honey");
        lista.add("1 tablespoon cider vinegar");
        lista.add("Kosher salt");
        lista.add("2 teaspoons dried oregano, preferably Mexican");
        lista.add("3 3/4 cups low-sodium chicken broth");
        lista.add("4 pounds boneless pork shoulder (untrimmed), cut into chunks");
        lista.add("Freshly ground pepper");
        lista.add("2 bay leaves");
        lista.add("1 cinnamon stick");
        lista.add("Corn tortillas, warmed, for serving");
        lista.add("Assorted taco toppings, for garnish");
        steps=new ArrayList<>();
        steps.add("1. Put the ancho and pasilla chiles and the garlic in a bowl; add 2 to 3 tablespoons water. Microwave on high until soft and pliable.");
        steps.add("2. Add the chipotles, onion, 2 tablespoons olive oil, honey, vinegar, 1 tablespoon salt and the oregano to the blender; puree until smooth. Heat the remaining 1 tablespoon oil in a large skillet over high heat; add the chile sauce and fry, stirring, until thick and fragrant, about 8 minutes. ");
        steps.add("3. Season the pork all over with salt and pepper and transfer to a large slow cooker. Add the bay leaves and cinnamon stick, then pour in the sauce. Cover and cook on high until the meat is tender, about 5 hours.");
        steps.add("4. Discard the bay leaves and cinnamon stick. Shred the pork with 2 forks; season with salt and pepper. Serve the shredded pork in the tortillas, along with toppings.");
        exampleList.add(new ExampleItem(R.drawable.pork_tacos, "Slow-Cooker Pork Tacos", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("1 to 2 tablespoons vinegar, like cider, balsamic, or red wine");
        lista.add("2 to 3 teaspoons dried herbs, like thyme, oregano, rosemary, or crumbled bay leaf");
        lista.add("1 to 2 tablespoons mustard, whole grain or Dijon");
        lista.add("1 to 2 teaspoon garlic or onion powder, optional");
        lista.add("1/4 cup extra-virgin olive oil ");
        lista.add("Kosher salt and freshly ground black pepper");
        lista.add("4 boneless, skinless chicken breast, each about 6 ounces");
        steps=new ArrayList<>();
        steps.add("1. Put the vinegar, herbs, mustard, powders if using and oil in a large re-sealable plastic bag. Close the bag and shake to combine all the ingredients. Open the bag, drop in the chicken breast in the bag. Close and shake the bag");
        steps.add("2. Thaw in the refrigerator overnight, under cold, running water, or in the microwave at 30 percent power for 1 minute at a time.");
        steps.add("3. Heat a grill or grill pan. When the grill is hot, place the chicken on the grill and cook for about 4 minutes per side, or until cooked through. You can also bake the thawed chicken in a 375 degree F oven for 15 minutes.");
        exampleList.add(new ExampleItem(R.drawable.cooked, "Marinated Chicken Breasts", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("2 teaspoons canola oil");
        lista.add("1/2 small red onion, diced (1 cup)");
        lista.add("1 red bell pepper, seeded and diced");
        lista.add("1 cup drained, rinsed canned black beans, preferably low-sodium");
        lista.add("1/4 teaspoon chili flakes");
        lista.add("Salt and freshly ground black pepper");
        lista.add("4 eggs and 4 egg whites");
        lista.add("1/3 cup (about 1 1/2 ounce) shredded pepper Jack cheese");
        lista.add("Nonstick cooking spray");
        lista.add("4 whole wheat tortillas");
        lista.add("1/4 cup reduced fat-free sour cream or 2 percent plain Greek yogurt");
        lista.add("1 large tomato, (4 ounces) seeded and diced");
        lista.add("1 small avocado (4 ounces), cubed");
        lista.add("Hot sauce");
        steps=new ArrayList<>();
        steps.add("1. Cook the onions and peppers until onions are softened and peppers are slightly charred, about 8 minutes. Add black beans and red pepper flakes and cook until warmed through, another 3 minutes. Season with salt and pepper.");
        steps.add("2. Whisk together the eggs and egg whites then stir in the cheese. Spray the skillet with cooking spray, and reheat the skillet over a medium heat. Reduce heat to low and add eggs, scrambling until cooked through, about 3 minutes. Spread each tortilla with 1 tablespoon each sour cream (or yogurt) and salsa, then layer with 1/4 of the black bean mixture, 1/4 of the scrambled eggs, some diced tomato and 1/4 of the avocado.");
        exampleList.add(new ExampleItem(R.drawable.burito, "Breakfast Burrito", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("2 tablespoons extra-virgin olive oil");
        lista.add("1/8 pound (about 3 slices) pancetta, chopped");
        lista.add("Two 4 to 6-inch sprigs rosemary, left intact");
        lista.add("One 4 to 6-inch sprig thyme with several sprigs on it, left intact");
        lista.add("1 large fresh bay leaf or 2 dried bay leaves");
        lista.add("1 medium onion, finely chopped");
        lista.add("1 small carrot, finely chopped");
        lista.add("1 rib celery, finely chopped");
        lista.add("4 large cloves garlic, chopped");
        lista.add("Coarse salt and pepper");
        lista.add("Two 15-ounce cans cannellini beans");
        lista.add("1 cup canned tomato sauce or canned crushed tomatoes");
        lista.add("2 cups water");
        lista.add("1 quart chicken stock");
        lista.add("1 1/2 cups ditalini");
        steps=new ArrayList<>();
        steps.add("1. Heat a deep pot over medium high heat and add oil and pancetta. Brown the pancetta bits lightly, and add herb stems, bay leaf, chopped vegetables, and garlic. Season vegetables with salt and pepper. Add beans, tomato sauce, water, and stock to pot and raise heat to high. Bring soup to a rapid boil and add pasta. Reduce heat to medium and cook soup, stirring occasionally, 6 to 8 minutes or until pasta is cooked al dente.");
        steps.add("2. Rosemary and thyme leaves will separate from stems as soup cooks. Remove herb stems and bay leaf from soup and place pot on table on a trivet. Let soup rest and begin to cool for a few minutes. Ladle soup into bowls and top with lots of grated cheese.");
        exampleList.add(new ExampleItem(R.drawable.pasta, "Pasta and Beans", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("4 skinless chicken breast halves, with ribs");
        lista.add("2 skinless chicken thighs, with bones");
        lista.add("1/2 teaspoon salt, plus 1 teaspoon");
        lista.add("1/2 teaspoon freshly ground black pepper, plus 1 teaspoon");
        lista.add("1/4 cup olive oil");
        lista.add("1 red bell pepper, sliced");
        lista.add("1 yellow bell pepper, sliced");
        lista.add("3 ounces prosciutto, chopped");
        lista.add("2 cloves garlic, chopped");
        lista.add("1 (15-ounce) can diced tomatoes");
        lista.add("1/2 cup white wine");
        lista.add("1 tablespoon fresh thyme leaves");
        lista.add("1 teaspoon fresh oregano leaves");
        lista.add("1/2 cup chicken stock");
        lista.add("2 tablespoons capers");
        lista.add("1/4 cup chopped fresh flat-leaf parsley leaves");
        steps=new ArrayList<>();
        steps.add("1. Season the chicken with 1/2 teaspoon salt and 1/2 teaspoon pepper. In a heavy, large skillet, heat the olive oil over medium heat. When the oil is hot, cook the chicken until browned on both sides. Remove from the pan and set aside.");
        steps.add("2. Add the peppers and prosciutto and cook until the peppers have browned and the prosciutto is crisp, about 5 minutes. Add the garlic and cook for 1 minute. Add the tomatoes, wine, and herbs. Using a wooden spoon, scrape the browned bits off the bottom of the pan. Return the chicken to the pan, add the stock, and bring the mixture to a boil.");
        steps.add("3. If serving immediately, add the capers and the parsley.");
        exampleList.add(new ExampleItem(R.drawable.piperki, "Roman-Style Chicken", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("4 (5 ounces each) salmon fillets");
        lista.add("2 teaspoons olive oil plus 2 tablespoons");
        lista.add("Salt and freshly ground black pepper");
        lista.add("3 tomatoes, chopped, or 1 (14-ounce) can chopped tomatoes, drained");
        lista.add("2 chopped shallots");
        lista.add("2 tablespoons fresh lemon juice");
        lista.add("1 teaspoon dried oregano");
        lista.add("1 teaspoon dried thyme");
        steps=new ArrayList<>();
        steps.add("1. Preheat the oven to 400 degrees F.");
        steps.add("2. Sprinkle salmon with 2 teaspoons olive oil, salt, and pepper. Stir the tomatoes, shallots, 2 tablespoons of oil, lemon juice, oregano, thyme, salt and pepper in a medium bowl to blend.");
        steps.add("3. lace a salmon fillet, oiled side down, atop a sheet of foil. Wrap the ends of the foil to form a spiral shape. Spoon the tomato mixture over the salmon. Fold the sides of the foil over the fish and tomato mixture, covering completely; seal the packets closed. Place the foil packet on a heavy large baking sheet. Repeat until all of the salmon have been individually wrapped in foil and placed on the baking sheet. Bake until the salmon is just cooked through, about 25 minutes.");
        exampleList.add(new ExampleItem(R.drawable.sal, "Salmon Baked in Foil", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("12 ounce salmon fillet, cut into 4 pieces");
        lista.add("Coarse-grained salt");
        lista.add("Freshly ground black pepper");
        lista.add("Toasted Almond Parsley Salsa, for serving");
        lista.add("Baked squash, for serving(optional)");
        lista.add("1 shallot(for salad)");
        lista.add("1 tablespoons red wine vinegar(for salad)");
        lista.add("Coarse grain salt(for salad)");
        lista.add("2 tablespoons capers, rinsed(for salad)");
        lista.add("1 cup fresh flat-leaf parsley(for salad)");
        lista.add("1/2 cup toasted almonds(for salad)");
        lista.add("Extra-virgin olive oil(for salad)");
        steps=new ArrayList<>();
        steps.add("1. Preheat the oven to 450 degrees F.");
        steps.add("2. Season salmon with salt and pepper. Place salmon, skin side down, on a non-stick baking sheet or in a non-stick pan with an oven-proof handle. Bake until salmon is cooked through, about 12 to 15 minutes.");
        steps.add("3. Mince the shallot and add to a small bowl. Pour the vinegar over the shallots and add a pinch of salt. Let sit for 30 minutes.(for salad)");
        steps.add("4. Roughly chop the capers, parsley and almonds and add to the shallots. Add the olive oil, tasting as you go.(for salad) ");
        exampleList.add(new ExampleItem(R.drawable.got, "Oven-Baked Salmon", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("2 cups dry elbow macaroni, cooked, rinsed, and drained");
        lista.add("1/3 cup diced celery");
        lista.add("1/4 cup minced red onion, soaked in cold water for 5 minutes, drained");
        lista.add("1 tablespoon minced flat-leaf parsley");
        lista.add("1/2 cup diced vine-ripened tomato ");
        lista.add("1/2 cup prepared mayonnaise");
        lista.add("3/4 teaspoon dry mustard");
        lista.add("1 1/2 teaspoons sugar");
        lista.add("1 1/2 tablespoons cider vinegar");
        lista.add("3 tablespoons sour cream");
        lista.add("1/2 teaspoon kosher salt, plus more to taste");
        lista.add("Freshly ground black pepper");
        steps=new ArrayList<>();
        steps.add("1. In a large bowl combine the macaroni, celery, onion, parsley and tomato, if using. In a small bowl, whisk together the mayonnaise, mustard, sugar, vinegar, sour cream and salt. ");
        steps.add("2.  Pour the dressing over the salad and stir to combine. Season with salt and pepper to taste. Serve. Store covered in the refrigerator, for up to 3 days.");
        exampleList.add(new ExampleItem(R.drawable.salad, "American Macaroni Salad", "Click for more...", lista, steps));

        lista = new ArrayList<>();
        lista.add("1 pound chicken breast (about 2 breasts)");
        lista.add("3 scallions, whites only, thinly sliced on a bias");
        lista.add("2 tablespoons sugar");
        lista.add("1 tablespoon dark sesame oil");
        lista.add("1 tablespoon dry sherry");
        lista.add("1 tablespoon soy sauce");
        lista.add("2 cloves garlic, minced");
        lista.add("1-inch piece peeled fresh ginger, minced");
        lista.add("1 tablespoon, plus 1 teaspoon cornstarch");
        lista.add("Kosher salt and freshly ground black pepper");
        lista.add("About 1/3 cup water");
        lista.add("3 tablespoons vegetable oil");
        lista.add("5 to 6 cups broccoli florets and sliced stalks (keep the 2 cuts separate)");
        lista.add("3/4 to 1 teaspoon red chili flakes(optional)");
        lista.add("1 tablespoon hoisin sauce");
        lista.add("Toasted sesame seeds(optional)");
        lista.add("Jasmine rice(optional)");
        steps=new ArrayList<>();
        steps.add("1. Toss the chicken with the scallion whites, sugar, sesame oil, sherry, soy sauce, about half the garlic, half the ginger, 1 teaspoon of the cornstarch and 1 teaspoon salt. Marinate at room temperature for 15 minutes. Mix the remaining 1 tablespoon cornstarch with 1/3 cup water");
        steps.add("2. Heat a large nonstick skillet over high heat. Add 1 tablespoon of the vegetable oil and heat. Add the broccoli stems and stir-fry for 30 seconds. Add the florets and the remaining garlic and ginger, 2 tablespoons water, 1/4 teaspoon salt and some black pepper. Stir-fry until the broccoli is bright green but still crisp, about 2 minutes.");
        steps.add("3. Add the chicken and red pepper flakes if using. Stir-fry until the chicken loses its raw color and gets a little brown, about 3 minutes. Add the hoisin sauce, return the broccoli to the pan and toss to heat through. Stir in the reserved cornstarch mixture and bring to a boil to thicken. ");
        steps.add("4. Mound the stir-fry on a serving platter or divide among 4 plates and garnish with sesame seeds; serve with rice.");
        exampleList.add(new ExampleItem(R.drawable.las, "Chicken and Broccoli Stir-Fry", "Click for more...", lista, steps));


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
                Intent intentStart=new Intent(getApplicationContext(),FoodDetails.class);
                intentStart.putExtra("title",exampleList.get(position).getmText1());
                intentStart.putExtra("image",exampleList.get(position).getmImageResource());
                intentStart.putExtra("list",exampleList.get(position).getLista());
                intentStart.putExtra("steps",exampleList.get(position).getSteps());
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
