package com.homework.hometask1;

import android.os.Parcel;
import android.os.Parcelable;

public class PlanetItem implements Parcelable {
    private int image;
    private String name;
    private int description;

    public PlanetItem(int image, String name, int description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    protected PlanetItem(Parcel in) {
        image = in.readInt();
        name = in.readString();
        description = in.readInt();
    }

    public static final Creator<PlanetItem> CREATOR = new Creator<PlanetItem>() {
        @Override
        public PlanetItem createFromParcel(Parcel in) {
            return new PlanetItem(in);
        }

        @Override
        public PlanetItem[] newArray(int size) {
            return new PlanetItem[size];
        }
    };

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeInt(description);
    }
}
