package com.example.sarah.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;
    CustomPagerAdapter customPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        toolbar = (Toolbar)findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);


        listView = (ListView)findViewById(R.id.listView1);

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

          ArrayList<ListItem> myList = new ArrayList<ListItem>();

        for (int i = 0; i < names.length; i++) {
            myList.add(new ListItem(names[i], number[i], images[i], lyric[i]));
        }

        CustomAdapter adapter = new CustomAdapter(this, myList);
        listView.setAdapter(adapter);


    }

}