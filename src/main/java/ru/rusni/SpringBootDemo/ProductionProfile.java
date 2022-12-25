package ru.rusni.SpringBootDemo;
public class ProductionProfile implements SystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is prod";
    }
}