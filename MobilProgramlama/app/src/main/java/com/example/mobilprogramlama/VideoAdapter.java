package com.example.mobilprogramlama;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobilprogramlama.model.VideoItem;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<VideoItem> videoItems;
    private Context context;

    public VideoAdapter(List<VideoItem> videoItems, Context context) {
        this.videoItems = videoItems;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoItem item = videoItems.get(position);

        holder.teamLogo.setImageResource(item.getImageResource());
        holder.teamName.setText(item.getTeam());
        holder.videoTitle.setText(item.getTitle());
        holder.videoDescription.setText(item.getDescription());
        holder.additionalInfo.setText(item.getAdditionalInfo());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("VIDEO_ID", item.getVideoId());
            intent.putExtra("TEAM_NAME", item.getTeam());
            intent.putExtra("VIDEO_TITLE", item.getTitle());
            intent.putExtra("VIDEO_DESCRIPTION", item.getDescription());
            intent.putExtra("TEAM_LOGO", item.getImageResource());
            intent.putExtra("ADDITIONAL_INFO", item.getAdditionalInfo());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView teamLogo;
        TextView teamName;
        TextView videoTitle;
        TextView videoDescription;
        TextView additionalInfo;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            teamLogo = itemView.findViewById(R.id.teamLogo);
            teamName = itemView.findViewById(R.id.teamName);
            videoTitle = itemView.findViewById(R.id.videoTitle);
            videoDescription = itemView.findViewById(R.id.videoDescription);
            additionalInfo = itemView.findViewById(R.id.additionalInfo);
        }
    }
} 