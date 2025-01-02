package com.example.mobilprogramlama.model;

public class VideoItem {
    private String videoId;
    private String title;
    private String description;
    private String team;
    private int teamColor;
    private int imageResource;
    private String additionalInfo;

    public VideoItem(String videoId, String title, String description, String team, int teamColor, int imageResource, String additionalInfo) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.team = team;
        this.teamColor = teamColor;
        this.imageResource = imageResource;
        this.additionalInfo = additionalInfo;
    }

    public String getVideoId() { return videoId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getTeam() { return team; }
    public int getTeamColor() { return teamColor; }
    public int getImageResource() { return imageResource; }
    public String getAdditionalInfo() {
        return additionalInfo;
    }
} 