package com.kroghpedersen.anettes_sandwich2;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RandomAdapterExtrapick extends BaseAdapter {

    Context context;
    List<ChoiceObj> ChoiceObjs;
    ChoiceObj choiceObj;

    public RandomAdapterExtrapick(Context context, List<ChoiceObj> uploadDTOs)
    {
        this.context   = context;
        this.ChoiceObjs = uploadDTOs;
    }

    @Override
    public int getCount() {
        return ChoiceObjs.size();
    }

    @Override
    public Object getItem(int position) {
        if (ChoiceObjs !=null)
        {
            return ChoiceObjs.get(position);
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null )
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.choice_item_extrapick,null);
        }
        choiceObj = ChoiceObjs.get(position);

        //Filling a item
        if(choiceObj != null)
        {
            TextView name = (TextView) convertView.findViewById(R.id.choice_item_txt);
            name.setText(choiceObj.name);

            ImageView pic = (ImageView) convertView.findViewById(R.id.choice_item_iv);
            pic.setImageBitmap(choiceObj.img);

            // set text font
            Typeface font = Typeface.createFromAsset(context.getAssets(), "font/Roboto-Bold.ttf");
            name.setTypeface(font);

        }
        return convertView;
    }

}
