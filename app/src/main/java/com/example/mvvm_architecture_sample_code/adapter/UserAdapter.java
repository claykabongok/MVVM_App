package com.example.mvvm_architecture_sample_code.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mvvm_architecture_sample_code.R;
import com.example.mvvm_architecture_sample_code.model.User;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context mContext;
    List<User> userList;

    public UserAdapter( List<User> usersList){
        this.mContext=mContext;
        this.userList =usersList;
    }

    /**
     * Called when RecyclerView needs a new {link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link # onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see # onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_users,parent,false);
        return new UserViewHolder(view);
    }
//    @NonNull
//    @Override
//    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.list_users,viewGroup,false);
//
//        return new UserViewHolder(view);
//    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        User userModel= userList.get(position);
       

        userViewHolder.name.setText("Name: "+userModel.getName());
        userViewHolder.username.setText("Username: "+userModel.getUsername());
        userViewHolder.email.setText("Email: "+userModel.getEmail());
        userViewHolder.phone.setText("Phone Number: "+userModel.getPhone());
        userViewHolder.website.setText("Website: "+userModel.getWebsite());


        userViewHolder.city.setText("City: "+userModel.getAddress().getCity());
        userViewHolder.zipcode.setText("zip code: "+userModel.getAddress().getZipcode());
        userViewHolder.street.setText("Street : "+userModel.getAddress().getStreet());
        userViewHolder.suite.setText("Suite : "+userModel.getAddress().getSuite());
        userViewHolder.lat.setText("Lat: "+userModel.getAddress().getGeo().getLat());
        userViewHolder.lng.setText("Lng: "+userModel.getAddress().getGeo().getLng());
        userViewHolder.company_name.setText("Company Name: "+userModel.getCompany().getName());
        userViewHolder.company_catchPhrase.setText("Company Catch Phrase: "+userModel.getCompany().getCatchPhrase());
        userViewHolder.bs.setText("Business Strategy: "+userModel.getCompany().getBs());



    }

    // Provide a reference to the views for each data item

    public static class UserViewHolder extends RecyclerView.ViewHolder{



        TextView name,username, email, phone, website,street,suite ,city,zipcode,lat,lng,company_name,company_catchPhrase,bs;
        // each data item is just a string in this case
        public UserViewHolder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.tv_name);
            username=itemView.findViewById(R.id.tv_username);
            email=itemView.findViewById(R.id.tv_email);
            phone=itemView.findViewById(R.id.tv_phone);
            website=itemView.findViewById(R.id.tv_website);
            street=itemView.findViewById(R.id.tv_street);
            suite=itemView.findViewById(R.id.tv_suite);
            city=itemView.findViewById(R.id.tv_city);
            zipcode=itemView.findViewById(R.id.tv_zipcode);
            lat=itemView.findViewById(R.id.tv_lat);
            lng=itemView.findViewById(R.id.tv_lng);
            company_name=itemView.findViewById(R.id.tv_company_name);
            company_catchPhrase=itemView.findViewById(R.id.tv_company_catchPhrase);
            bs=itemView.findViewById(R.id.tv_bs);





        }
    }
    @Override
    public int getItemCount() {
        return userList.size();
    }



}
