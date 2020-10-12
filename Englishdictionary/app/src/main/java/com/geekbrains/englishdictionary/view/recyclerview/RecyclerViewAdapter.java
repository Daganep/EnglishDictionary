package com.geekbrains.englishdictionary.view.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geekbrains.englishdictionary.R;
import com.geekbrains.englishdictionary.model.entity.SearchResult;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder> {

    private List<SearchResult> data;

    public RecyclerViewAdapter(List<SearchResult> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.image_view_holder;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{

        TextView mainText;
        TextView meanText;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            mainText = itemView.findViewById(R.id.textMain);
            meanText = itemView.findViewById(R.id.textMean);
        }

        void bind(SearchResult data){
            mainText.setText(data.getText());
            meanText.setText(data.getMeanings().get(0).getTranslation().getTranslation());
        }
    }
}

