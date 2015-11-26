package com.example.sarah.listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sarah on 10/22/theme.
 */

        public class CustomAdapter extends BaseAdapter {

            ArrayList<ListItem> myList = new ArrayList<ListItem>();
            Context context;
    ListItem listItem;

            // on passe le context afin d'obtenir un LayoutInflater pour utiliser notre
            // row_layout.xml
            // on passe les valeurs de notre à l'adapter
            public CustomAdapter(Context context, ArrayList<ListItem> myList) {
                this.myList = myList;
                this.context = context;
            }

            // retourne le nombre d'objet présent dans notre liste
            @Override
            public int getCount() {
                return myList.size();
            }

            // retourne un élément de notre liste en fonction de sa position
            @Override
            public ListItem getItem(int position) {
                return myList.get(position);
            }

            // retourne l'id d'un élément de notre liste en fonction de sa position
            @Override
            public long getItemId(int position) {
                return myList.indexOf(getItem(position));
            }

            // retourne la vue d'un élément de la liste
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                MyViewHolder mViewHolder = null;

                // au premier appel ConvertView est null, on inflate notre layout
                if (convertView == null) {
                    LayoutInflater mInflater = (LayoutInflater) context
                            .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

                    convertView = mInflater.inflate(R.layout.row_list, parent, false);

                    // nous plaçons dans notre MyViewHolder les vues de notre layout
                    mViewHolder = new MyViewHolder();
                    mViewHolder.textViewName = (TextView) convertView
                            .findViewById(R.id.textViewName);
                    mViewHolder.textViewAge = (TextView) convertView
                            .findViewById(R.id.textViewAge);
                    mViewHolder.imageView = (ImageView) convertView
                            .findViewById(R.id.imageView);

                    // nous attribuons comme tag notre MyViewHolder à convertView
                    convertView.setTag(mViewHolder);
                } else {
                    // convertView n'est pas null, nous récupérons notre objet MyViewHolder
                    // et évitons ainsi de devoir retrouver les vues à chaque appel de getView
                    mViewHolder = (MyViewHolder) convertView.getTag();
                }

                // nous récupérons l'item de la liste demandé par getView
                final ListItem listItem = getItem(position);

                // nous pouvons attribuer à nos vues les valeurs de l'élément de la liste
                mViewHolder.textViewName.setText(listItem.getName());
                mViewHolder.textViewAge.setText(String.valueOf(" Page: " + listItem.getNumber())
                  );
                mViewHolder.imageView.setImageResource(listItem.getImageId());

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent =new Intent(context,SongActivity.class);
                        intent.putExtra("sarah",listItem);
                        context.startActivity(intent);
                    }
                });

                // nous retournos la vue de l'item demandé
                return convertView;
            }

            // MyViewHolder va nous permettre de ne pas devoir rechercher
            // les vues à chaque appel de getView, nous gagnons ainsi en performance
            private class MyViewHolder {
                TextView textViewName, textViewAge;
                ImageView imageView;
            }

}
