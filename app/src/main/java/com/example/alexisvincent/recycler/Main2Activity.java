package com.example.alexisvincent.recycler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;


public class Main2Activity extends AppCompatActivity {
    private StorageReference mStorageRef;
    private ProgressDialog mProgress;
    private static int CAMERA_REQUEST_CODE = 1;
    //private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mStorageRef = FirebaseStorage.getInstance().getReference();
        mProgress = new ProgressDialog(this);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, CAMERA_REQUEST_CODE);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK){
            mProgress.setMessage("Uploading Image...");
            mProgress.show();
            Uri uri = data.getData();

            StorageReference filePath = mStorageRef.child("Photos").child(uri.getLastPathSegment());
            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mProgress.dismiss();
                    Toast.makeText(Main2Activity.this, "Uploading Finished...", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}