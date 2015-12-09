package com.example.sarah.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.sarah.listview.R.id.viewpager;

public class SongActivity extends AppCompatActivity {

    TextView lyricView;
    ListItem listItem;
    TextView songNumber;
    Toolbar toolbar;
    ViewPager viewPager;
    CustomPagerAdapter customPagerAdapter;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);
        toolbar = (Toolbar)findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager)findViewById(viewpager);

        String[] names = new String[] { "1. ALLELUIA! LE SEIGNEUR DIEU ", "2. AMEN! AMEN!",
                "3. CE QUE DIEU A FAIT POUR MOI ", "4. EN JESUS, J’AI TROUVE", "5. I HAVE SEEN THE LIGHT ", "6. LOUONS L’ETERNEL",
                "7. NUL N’EST SAINT COMME L’ETERNEL", "8. QUI EST COMME TOI", "9. SAINT, SAINT, SAINT, EST L’ETERNEL",
                "10. A DIEU SOIT LA GLOIRE!"};

        String[] lyric = new String[]{ "Alléluia! Le seigneur dieu \n" +
                "Alléluia! Le seigneur dieu\n" +
                "Omnipotent règne ;\n" +
                "Alléluia Alléluia, o Seigneur !\n" +
                "Hallelujah for the Lord God\n" +
                "Omnipotent reigneth,\n" +
                "Hallelujah to the Lord", "Amen! Amen! Louange et gloire\n" +
                "Action de grâces, et honneur,\n" +
                "Et la puissance, soit à notre Dieu\n" +
                "Aux siècles des siècles, Amen!", "Ce que Dieu a fait pour moi, \n" +
                "Je ne peux pas tout le dire\n" +
                "Il m’a sauvé, m’a lave dans Son sang\n" +
                "Je peux chanter: Alléluia! (bis)\n" +
                "Je peux chanter et louer Dieu! \n" +
                "What the Lord has done for me,\n" +
                "I cannot tell it all\n" +
                "And I can shout: Hallelujah (bis)\n" +
                "I can shout and praise the Lord", "En Jesus, j’ai trouvé\n" +
                "Ce que je n’espérais pas\n" +
                "Il m’a donné la vie, \n" +
                "Ce que je n’espérais pas\n" +
                "Il m’a donné la l’espoir, \n" +
                "Ce que je n’espérais pas\n" +
                "Il m’a donné la paix, \n" +
                "Ce que je n’espérais pas.\n" +
                "C’est pourquoi je Le chante.", "I have seen the light,\n" +
                "The light of God,\n" +
                "I have seen the light,\n" +
                "Shine in my heart,\n" +
                "I have seen the light,\n" +
                "The light of God,\n" +
                "Shine in my heart.", "Louons l’Eternel,\n" +
                "En tout lieu, en tout temps:\n" +
                "Louons l’Eternel,\n" +
                "N’importe où, n’importe quand.\n" +
                "Dans ta maison, il faut Le louer.\n" +
                "Dans ton école, il faut Le louer.", "Nul n’est saint comme l’Eternel ;\n" +
                "Nul n’est saint comme l’Eternel ;\n" +
                "Il n’y a point d’autre Dieu que Toi ;\n" +
                "Il n’y a point de rocher comme notre Dieu,\n" +
                "Nul n’est saint comme l’Eternel.\n" +
                "There is none holy as the Lord,\n" +
                "There is none beside Thee,\n" +
                "Neither is there any rock\n" +
                "Like our God\n" +
                "There is none holy as the Lord.", "Qui est comme Toi,\n" +
                "O Seigneur?\n" +
                "Parmi les Dieux, qui est comme toi?\n" +
                "Magnifique en saintété, Digne de louanges,\n" +
                "Opérant des prodiges?\n" +
                "Who is like unto thee,\n" +
                "O Lord?\n" +
                "Amongst the gods,\n" +
                "Who is like thee?\n" +
                "Glorious in holiness,\n" +
                "Fearful in praises;\n" +
                "Doing wonders hallelujah.", "Saint, saint, saint, est l’Eternel\n" +
                "Chaque jour, Il est le même,\n" +
                "Sa bonté et Sa fidélité \n" +
                "Pour nous demeurent éternellement. ", "A Dieu soit la gloire!\n" +
                "Pour son grand amour,\n" +
                "Dans mon âme noire,\n" +
                "C’est levé le jour,\n" +
                "Jésus à ma place\n" +
                "Mourut sur la croix,\n" +
                "Il m’offre sa grâce et je la reçois\n" +
                "      Chœur :\n" +
                "Gloire à Dieu! (bis)\n" +
                "Terre écoute Sa voix!\n" +
                "Gloire à Dieu! (bis)\n" +
                "Monde réjouis-toi!\n" +
                "Oh venez au père,\n" +
                "Jésus est vainqueur,\n" +
                "Que toute la terre,\n" +
                "Chante en Son honneur!\n" +
                "\n" +
                "2.  De jésus la joie, remplit notre cœur,\n" +
                "Qu’importe qu’on voit\n" +
                "Tout notre bonheur.\n" +
                "\n" +
                "3.  Selon Sa promesse,\n" +
                "Jésus changera\n" +
                "Deuil en allégresse,\n" +
                " Quand Il reviendra.\n" +
                "\tGloire à Dieu! " };

        int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] images = { R.drawable.mon5, R.drawable.mon5,
                R.drawable.mon5, R.drawable.mon5,
                R.drawable.mon5, R.drawable.mon5, R.drawable.mon5,
                R.drawable.mon5, R.drawable.mon5, R.drawable.mon5  };

        final ArrayList<ListItem> myList = new ArrayList<ListItem>();

        for (int i = 0; i < names.length; i++) {
            myList.add(new ListItem(names[i], number[i], images[i], lyric[i]));
        }

        customPagerAdapter = new CustomPagerAdapter(this,myList);

        viewPager.setAdapter(customPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                getSupportActionBar().setTitle(myList.get(position).getName());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Intent intent = getIntent();
        //listItem = (ListItem)intent.getSerializableExtra("sarah");

        //lyricView = (TextView)findViewById(R.id.song1);
        //lyricView.setText(listItem.getLyrics());
           }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
