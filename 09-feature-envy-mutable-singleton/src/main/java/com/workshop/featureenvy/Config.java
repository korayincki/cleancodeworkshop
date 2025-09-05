package com.workshop.featureenvy;

// Dirty: mutable global singleton
public class Config {
    private static Config INSTANCE = new Config();
    public final double tax = 0.18;
    private Config(){}
    public static Config get(){ return INSTANCE; }
    private static void set(Config c){ INSTANCE = c; } // anyone can swap
}
