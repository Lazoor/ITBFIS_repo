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
 * Created by bagge on 05-12-2016.
 */

public class CheckboxAdapter extends BaseAdapter {

    Context context;
    List<CheckboxObject> checkboxObjects;
    CheckboxObject checkboxObject;

    public CheckboxAdapter(Context context, List<CheckboxObject> checkboxObjects)
    {
        this.context         = context;
        this.checkboxObjects = checkboxObjects;
    }

    @Override
    public int getCount() {
        return checkboxObjects.size();
    }

    @Override
    public Object getItem(int position) {
        if (checkboxObjects !=null)
        {
            return checkboxObjects.get(position);
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
            convertView = layoutInflater.inflate(R.layout.item_checkbox_layout,null);
        }
        checkboxObject = checkboxObjects.get(position);

        //Filling a item
        if(checkboxObject != null)
        {
            ImageView item_image_imageview = (ImageView) convertView.findViewById(R.id.item_image_imageview);
            item_image_imageview.setImageBitmap(checkboxObject.getImage());

            TextView item_title_textview = (TextView) convertView.findViewById(R.id.item_title_textview);
            item_title_textview.setText(checkboxObject.getTitle());

            TextView item_info_textview = (TextView) convertView.findViewById(R.id.item_info_textview);
            item_info_textview.setText(checkboxObject.getInfo());
        }
        return convertView;
    }

}