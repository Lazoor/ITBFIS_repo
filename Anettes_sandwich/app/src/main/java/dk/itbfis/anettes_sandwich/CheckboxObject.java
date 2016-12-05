package dk.itbfis.anettes_sandwich;

import android.graphics.Bitmap;

/**
 * Created by bagge on 05-12-2016.
 */

public class CheckboxObject {


    public CheckboxObject(Bitmap image, String title, String info) {
        this.image = image;
        this.title = title;
        this.info = info;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private Bitmap image;
    private String title;
    private String info;
}
