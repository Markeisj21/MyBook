package com.markeisjones.mybook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder>{
    private Context mContext ;
    private List<Book> mBook;
    RequestOptions option;

    public BookAdapter(Context mContext, List<Book> mBook) {
        this.mContext = mContext;
        this.mBook = mBook;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground);


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.single_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitle.setText(mBook.get(position).getTitle());
        holder.mAuthor.setText(mBook.get(position).getAuthor());

        Glide.with(mContext).load(mBook.get(position).getImageURL()).apply(option).into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        return mBook.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle ;
        TextView mAuthor;
        ImageView mImage;


        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.main_title);
            mAuthor = itemView.findViewById(R.id.main_author);
            mImage = itemView.findViewById(R.id.main_image);
        }
    }


}
