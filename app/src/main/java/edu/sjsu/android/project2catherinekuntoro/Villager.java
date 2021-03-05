package edu.sjsu.android.project2catherinekuntoro;

public class Villager {

    String duckName;
    int drawableImage;

    public String getDuckName() {
        return duckName;
    }

    public void setDuckName(String duckName) {
        this.duckName = duckName;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }

    public Villager(String name, int drawableImage) {
        this.duckName = name;
        this.drawableImage = drawableImage;
    }
}
