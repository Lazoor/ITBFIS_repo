package dk.itbfis.anettes_sandwich;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.List;

/**
 * Created by bagge on 30-11-2016.
 */

public class ButtonLibrary {

    Context context;

    public ButtonLibrary() {
        Bitmap sandwichIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.american_flag);

        ButtonObject sandwichChoice = new ButtonObject(sandwichIcon, "Title", "Info");

        sandwichChoices.add(sandwichChoice);
    }

    static List<ButtonObject> sandwichChoices;



}
