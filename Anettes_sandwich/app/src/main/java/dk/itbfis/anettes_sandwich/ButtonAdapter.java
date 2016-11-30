package dk.itbfis.anettes_sandwich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bagge on 30-11-2016.
 */


public class ButtonAdapter extends BaseAdapter {

    Context context;
    List<ButtonObject> buttonObjects;
    ButtonObject buttonObject;

    public ButtonAdapter(Context context, List<ButtonObject> buttonObjects)
    {
        this.context       = context;
        this.buttonObjects = buttonObjects;
    }

    @Override
    public int getCount() {
        return buttonObjects.size();
    }

    @Override
    public Object getItem(int position) {
        if (buttonObjects !=null)
        {
            return buttonObjects.get(position);
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
            convertView = layoutInflater.inflate(R.layout.item_button_layout,null);
        }
        buttonObject = buttonObjects.get(position);

        //Filling a item
        if(buttonObject != null)
        {
            ImageView item_image_imageview = (ImageView) convertView.findViewById(R.id.item_image_imageview);
            item_image_imageview.setImageBitmap(buttonObject.getImage());

            TextView item_title_textview = (TextView) convertView.findViewById(R.id.item_title_textview);
            item_title_textview.setText(buttonObject.getTitle());

            TextView item_info_textview = (TextView) convertView.findViewById(R.id.item_info_textview);
            item_info_textview.setText(buttonObject.getInfo());
        }
        return convertView;
    }

}