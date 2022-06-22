package com.example.musicplayer;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class PlayerFragment extends Fragment {
    private ArrayList<AudioModel> music = new ArrayList<>();

    public PlayerFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void getMusics(){
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[]{MediaStore.Audio.Media.TITLE,MediaStore.Audio.Media.ARTIST,MediaStore.Audio.Media._ID,MediaStore.Audio.Media.ALBUM_ID,MediaStore.Audio.Media.DURATION};
        Cursor cursor = getActivity().getContentResolver().query(uri,projection,null,null,null);
        if(cursor != null) {
            cursor.moveToFirst();
            while (cursor.moveToNext()){
                AudioModel model = new AudioModel();
                String name = cursor.getString(0);
                String artist = cursor.getString(1);
                long id = cursor.getLong(2);
                long albumid = cursor.getLong(3);
                long duration = cursor.getLong(4);

                model.setMusic_name(name);
                model.setMusic_Artist(artist);
                model.setMusicID(id);
                model.setMusic_album_id(albumid);
                model.setDuration(duration);

                music.add(model);
            }
        }
        cursor.close();
    }
}
