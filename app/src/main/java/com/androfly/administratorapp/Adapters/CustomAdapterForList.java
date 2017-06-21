package com.androfly.administratorapp.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.androfly.administratorapp.Models.GetUserData;
import com.androfly.administratorapp.R;

import java.util.ArrayList;


/**
 * Created by VASU on 1/2/2017.
 */
public class CustomAdapterForList extends ArrayAdapter<GetUserData> implements View.OnClickListener,Filterable {


    private ArrayList<GetUserData> originalList;
    private ArrayList<GetUserData> usersList;

    public CustomAdapterForList(Context context, int textViewResourceId,
                                    ArrayList<GetUserData> usersList) {
        super(context, textViewResourceId, usersList);
        this.usersList = new ArrayList<GetUserData>();
        this.usersList.addAll(usersList);
        this.originalList = new ArrayList<GetUserData>();
        this.originalList.addAll(usersList);
    }

    @Override
    public void onClick(View v) {

    }


    private class ViewHolder {
        public TextView name;
        public TextView gender;
        public TextView college;
        public TextView subject;
        public TextView uid;
        public TextView phone;
        public ImageView image ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyData", getContext().MODE_PRIVATE);

        String user_name = sharedPreferences.getString("Name", "");

        //  position = usersList.size() - position - 1;

        final GetUserData users = usersList.get(position);

        final String description;

        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_item_for_all_users, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.gender = (TextView) convertView.findViewById(R.id.gender);
            holder.college = (TextView) convertView.findViewById(R.id.college);
            holder.subject = (TextView) convertView.findViewById(R.id.subject);
            holder.uid = (TextView) convertView.findViewById(R.id.uid);
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            holder.image = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(users.getName());
        holder.gender.setText(users.getGender());
        holder.college.setText(users.getCollege());
        holder.subject.setText(users.getSubject());
        holder.uid.setText(users.getUid());
        holder.phone.setText(users.getPhone());


        return convertView;

    }
}