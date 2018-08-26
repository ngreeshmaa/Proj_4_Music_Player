package com.example.ins15.music_player;

import android.os.Parcel;
import android.os.Parcelable;

public class song_view implements Parcelable {
    private String mSongName;
    private String mSongAtrist;
    private String mSongLength;
    private int mSongImage;
    private int mbackgroundImage;


     song_view(String songName, String songArtist, String songLength, int songImage, int backgroundImage) {
        mSongName = songName;
        mSongAtrist = songArtist;
        mSongLength = songLength;
        mSongImage = songImage;
        mbackgroundImage = backgroundImage;
    }


    private song_view(Parcel in) {
        mSongName = in.readString();
        mSongAtrist = in.readString();
        mSongLength = in.readString();
        mSongImage = in.readInt();
        mbackgroundImage = in.readInt();

    }

    public static final Creator<song_view> CREATOR = new Creator<song_view>() {
        @Override
        public song_view createFromParcel(Parcel in) {
            return new song_view(in);
        }

        @Override
        public song_view[] newArray(int size) {
            return new song_view[size];
        }
    };

    public String getSongName() {

        return mSongName;
    }

    public String getSongLength() {

        return mSongLength;
    }

    public String getSongAtrist() {

        return mSongAtrist;
    }

    public int getbackgroundImage() {
        return mbackgroundImage;
    }

    public int getSongImage() {
        return mSongImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSongName);
        parcel.writeString(mSongAtrist);
        parcel.writeString(mSongLength);
        parcel.writeInt(mSongImage);
        parcel.writeInt(mbackgroundImage);

    }
}
