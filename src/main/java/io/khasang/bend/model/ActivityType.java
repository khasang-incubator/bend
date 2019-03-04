package io.khasang.bend.model;

public enum ActivityType {
    WAKEBOARD,
    KITESURF,
    SURF;
    private int experienceAmount; //

    public int getExperienceAmount() {
        return experienceAmount;
    }

    public void setExperienceAmount(int experienceAmount) {
        this.experienceAmount = experienceAmount;
    }
}
